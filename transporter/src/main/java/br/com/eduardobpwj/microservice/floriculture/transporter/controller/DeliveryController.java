package br.com.eduardobpwj.microservice.floriculture.transporter.controller;

import br.com.eduardobpwj.microservice.floriculture.transporter.dto.DeliveryDTO;
import br.com.eduardobpwj.microservice.floriculture.transporter.dto.VoucherDTO;
import br.com.eduardobpwj.microservice.floriculture.transporter.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @RequestMapping(method = RequestMethod.POST)
    public VoucherDTO deliveryReservation(@RequestBody DeliveryDTO dto) {
        return deliveryService.deliveryReservation(dto);
    }
}