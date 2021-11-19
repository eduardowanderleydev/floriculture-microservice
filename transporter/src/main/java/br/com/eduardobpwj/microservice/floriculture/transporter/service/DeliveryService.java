package br.com.eduardobpwj.microservice.floriculture.transporter.service;

import br.com.eduardobpwj.microservice.floriculture.transporter.dto.DeliveryDTO;
import br.com.eduardobpwj.microservice.floriculture.transporter.dto.VoucherDTO;
import br.com.eduardobpwj.microservice.floriculture.transporter.model.Delivery;
import br.com.eduardobpwj.microservice.floriculture.transporter.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository repository;

    public VoucherDTO deliveryReservation(DeliveryDTO dto) {

        Delivery delivery = new Delivery();
        delivery.setDeliveryDate(dto.getDeliveryDate());
        delivery.setDeliveryForecast(dto.getDeliveryDate().plusDays(1l));
        delivery.setTargetAddress(dto.getTargetAddress());
        delivery.setSourceAddress(dto.getSourceAddress());
        delivery.setOrderId(dto.getOrderId());

        repository.save(delivery);

        VoucherDTO voucher = new VoucherDTO();
        voucher.setNumber(delivery.getId());
        voucher.setDeliveryForecast(delivery.getDeliveryForecast());
        return voucher;
    }

}
