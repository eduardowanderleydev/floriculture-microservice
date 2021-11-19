package br.com.eduardobpwj.microservice.floriculture.store.client;

import br.com.eduardobpwj.microservice.floriculture.store.controller.dto.InfoDeliveryDTO;
import br.com.eduardobpwj.microservice.floriculture.store.controller.dto.VoucherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("transporter")
public interface TransporterClient {

    @RequestMapping(method = RequestMethod.POST, path = "/delivery")
    VoucherDTO deliveryReservation(InfoDeliveryDTO dto);
}
