package br.com.eduardobpwj.microservice.floriculture.provider.controller;

import br.com.eduardobpwj.microservice.floriculture.provider.controller.dto.OrderItemDTO;
import br.com.eduardobpwj.microservice.floriculture.provider.model.Order;
import br.com.eduardobpwj.microservice.floriculture.provider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService service;

    @RequestMapping(method = RequestMethod.POST)
    public Order makeOrder(@RequestBody List<OrderItemDTO> products) {
        return service.makeOrder(products);
    }

    @RequestMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }
}
