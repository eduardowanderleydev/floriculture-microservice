package br.com.eduardobpwj.microservice.floriculture.store.service;

import br.com.eduardobpwj.microservice.floriculture.store.client.ProviderClient;
import br.com.eduardobpwj.microservice.floriculture.store.controller.dto.InfoProviderDTO;
import br.com.eduardobpwj.microservice.floriculture.store.controller.dto.PurchaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    private ProviderClient client;

    public void makePurchase(PurchaseDTO purchase) {
        InfoProviderDTO info = client.getInfoByState(purchase.getAddress().getState());

        System.out.println(info);
    }

}