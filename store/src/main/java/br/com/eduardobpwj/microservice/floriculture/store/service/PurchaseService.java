package br.com.eduardobpwj.microservice.floriculture.store.service;

import br.com.eduardobpwj.microservice.floriculture.store.controller.dto.InfoProviderDTO;
import br.com.eduardobpwj.microservice.floriculture.store.controller.dto.PurchaseDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PurchaseService {


    public void makePurchase(PurchaseDTO purchase) {

        RestTemplate client = new RestTemplate();
        ResponseEntity<InfoProviderDTO> exchange = client.exchange("http://localhost:8081/info/" + purchase.getAddress().getState(),
                HttpMethod.GET,
                null,
                InfoProviderDTO.class);

        System.out.println(exchange.getBody().getAddress());
    }

}
