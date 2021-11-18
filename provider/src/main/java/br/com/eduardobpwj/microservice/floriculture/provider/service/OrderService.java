package br.com.eduardobpwj.microservice.floriculture.provider.service;

import br.com.eduardobpwj.microservice.floriculture.provider.controller.dto.OrderItemDTO;
import br.com.eduardobpwj.microservice.floriculture.provider.model.Order;
import br.com.eduardobpwj.microservice.floriculture.provider.model.OrderItem;
import br.com.eduardobpwj.microservice.floriculture.provider.model.Product;
import br.com.eduardobpwj.microservice.floriculture.provider.repository.OrderRepository;
import br.com.eduardobpwj.microservice.floriculture.provider.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order makeOrder(List<OrderItemDTO> items) {

        if (items == null) {
            return null;
        }

        List<OrderItem> pedidoItens = toOrderItem(items);
        Order pedido = new Order(pedidoItens);
        pedido.setPrepareTime(items.size());
        return orderRepository.save(pedido);
    }

    public Order getOrderById(Long id) {
        return this.orderRepository.findById(id).orElse(new Order());
    }

    private List<OrderItem> toOrderItem(List<OrderItemDTO> items) {

        List<Long> idsProducts = items
                .stream()
                .map(item -> item.getId())
                .collect(Collectors.toList());

        List<Product> orderProducts = productRepository.findByIdIn(idsProducts);

        List<OrderItem> orderItems = items
                .stream()
                .map(item -> {
                    Product product
                            = orderProducts
                            .stream()
                            .filter(p -> p.getId() == item.getId())
                            .findFirst().get();

                    OrderItem pedidoItem = new OrderItem();
                    pedidoItem.setProduct(product);
                    pedidoItem.setQuantity(item.getQuantidade());
                    return pedidoItem;
                })
                .collect(Collectors.toList());
        return orderItems;
    }

}
