package br.com.eduardobpwj.microservice.floriculture.store.controller;

import br.com.eduardobpwj.microservice.floriculture.store.controller.dto.PurchaseDTO;
import br.com.eduardobpwj.microservice.floriculture.store.model.Purchase;
import br.com.eduardobpwj.microservice.floriculture.store.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public Purchase makePurchase(@RequestBody PurchaseDTO purchase){
        return purchaseService.makePurchase(purchase);
    }

}