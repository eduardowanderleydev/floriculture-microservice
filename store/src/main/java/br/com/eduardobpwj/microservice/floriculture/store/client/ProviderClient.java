package br.com.eduardobpwj.microservice.floriculture.store.client;

import br.com.eduardobpwj.microservice.floriculture.store.controller.dto.InfoProviderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("provider")
public interface ProviderClient {

    @RequestMapping("/info/{state}")
    InfoProviderDTO getInfoByState(@PathVariable String state);

}
