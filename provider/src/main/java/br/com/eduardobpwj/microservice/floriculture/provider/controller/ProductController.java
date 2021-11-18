package br.com.eduardobpwj.microservice.floriculture.provider.controller;

import br.com.eduardobpwj.microservice.floriculture.provider.model.Product;
import br.com.eduardobpwj.microservice.floriculture.provider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @RequestMapping("/{estado}")
    public List<Product> getProdutosPorEstado(@PathVariable("estado") String estado) {
        return service.getProdutosPorEstado(estado);
    }

}
