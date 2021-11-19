package br.com.eduardobpwj.microservice.floriculture.store.service;

import br.com.eduardobpwj.microservice.floriculture.store.client.ProviderClient;
import br.com.eduardobpwj.microservice.floriculture.store.client.TransporterClient;
import br.com.eduardobpwj.microservice.floriculture.store.controller.dto.*;
import br.com.eduardobpwj.microservice.floriculture.store.model.Purchase;
import br.com.eduardobpwj.microservice.floriculture.store.repository.PurchaseRepository;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PurchaseService {

    @Autowired
    private ProviderClient providerClient;

    @Autowired
    private TransporterClient transporterClient;

    @Autowired
    private PurchaseRepository repository;

    @HystrixCommand(threadPoolKey = "getByIdThreadPool")
    public Purchase getById(Long id) {
        return repository.findById(id).orElse(new Purchase());
    }

    @HystrixCommand(fallbackMethod = "makePurchaseFallback",
    threadPoolKey = "makePurchaseThreadPool")
    public Purchase makePurchase(PurchaseDTO purchase) {
        InfoProviderDTO providerInfo = providerClient.getInfoByState(purchase.getAddress().getState());

        OrderInfoDTO orderInfo = providerClient.makeOrder(purchase.getItens());

        InfoDeliveryDTO deliveryInfo = new InfoDeliveryDTO();
        deliveryInfo.setOrderId(orderInfo.getId());
        deliveryInfo.setDeliveryDate(LocalDate.now().plusDays(orderInfo.getPrepareTime()));
        deliveryInfo.setSourceAddress(providerInfo.getAddress());
        deliveryInfo.setTargetAddress(purchase.getAddress().toString());
        VoucherDTO voucher = transporterClient.deliveryReservation(deliveryInfo);

        Purchase savedPurchase = new Purchase();
        savedPurchase.setIdOrder(orderInfo.getId());
        savedPurchase.setTargetAddress(purchase.getAddress().toString());
        savedPurchase.setPrepareTime(orderInfo.getPrepareTime());
        savedPurchase.setDeliveryForecast(voucher.getDeliveryForecast());
        savedPurchase.setVoucher(voucher.getNumber());
        repository.save(savedPurchase);
        return savedPurchase;
    }

    public Purchase makePurchaseFallback(PurchaseDTO purchase) {
        Purchase fallBackPurchase = new Purchase();
        fallBackPurchase.setTargetAddress("something is wrong, im returning a fallback");
        return fallBackPurchase;
    }
}