package br.com.eduardobpwj.microservice.floriculture.provider.service;

import br.com.eduardobpwj.microservice.floriculture.provider.model.Product;
import br.com.eduardobpwj.microservice.floriculture.provider.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getProdutosPorEstado(String state) {
        return repository.findByState(state);
    }
}
