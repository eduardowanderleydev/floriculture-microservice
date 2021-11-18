package br.com.eduardobpwj.microservice.floriculture.store.client;

import br.com.eduardobpwj.microservice.floriculture.store.controller.dto.InfoProviderDTO;
import br.com.eduardobpwj.microservice.floriculture.store.controller.dto.OrderInfoDTO;
import br.com.eduardobpwj.microservice.floriculture.store.controller.dto.PurchaseItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("provider")
public interface ProviderClient {

    @RequestMapping("/info/{state}")
    InfoProviderDTO getInfoByState(@PathVariable String state);

    @RequestMapping(method = RequestMethod.POST, value = "/order")
    OrderInfoDTO makeOrder(List<PurchaseItemDTO> items);
}
