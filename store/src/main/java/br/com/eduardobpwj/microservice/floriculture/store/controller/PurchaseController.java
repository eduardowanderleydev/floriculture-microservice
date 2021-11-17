package br.com.eduardobpwj.microservice.floriculture.store.controller;

import br.com.eduardobpwj.microservice.floriculture.store.controller.dto.PurchaseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @PostMapping
    public void makePurchase(@RequestBody PurchaseDTO purchase) {
    }

}