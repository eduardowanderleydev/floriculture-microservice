package br.com.eduardobpwj.microservice.floriculture.store.service;

import br.com.eduardobpwj.microservice.floriculture.store.client.ProviderClient;
import br.com.eduardobpwj.microservice.floriculture.store.controller.dto.InfoProviderDTO;
import br.com.eduardobpwj.microservice.floriculture.store.controller.dto.OrderInfoDTO;
import br.com.eduardobpwj.microservice.floriculture.store.controller.dto.PurchaseDTO;
import br.com.eduardobpwj.microservice.floriculture.store.model.Purchase;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    private ProviderClient client;

    @HystrixCommand(fallbackMethod = "makePurchaseFallback")
    public Purchase makePurchase(PurchaseDTO purchase) {
        InfoProviderDTO info = client.getInfoByState(purchase.getAddress().getState());

        OrderInfoDTO order = client.makeOrder(purchase.getItens());

        System.out.println(info);

        Purchase savedPurchase = new Purchase();
        savedPurchase.setIdOrder(order.getId());
        savedPurchase.setTargetAddress(purchase.getAddress().toString());
        savedPurchase.setPrepareTime(order.getPrepareTime());
        return savedPurchase;
    }

    public Purchase makePurchaseFallback(PurchaseDTO purchase) {
        Purchase fallBackPurchase = new Purchase();
        fallBackPurchase.setTargetAddress("fallback");
        return fallBackPurchase;
    }

}