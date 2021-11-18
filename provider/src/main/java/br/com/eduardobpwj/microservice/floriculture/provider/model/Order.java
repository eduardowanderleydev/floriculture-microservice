package br.com.eduardobpwj.microservice.floriculture.provider.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer prepareTime;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private List<OrderItem> items;

    public Order(List<OrderItem> items) {
        this.items = items;
        this.orderStatus = OrderStatus.RECEIVED;
    }

    public Order() {
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> itens) {
        this.items = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus status) {
        this.orderStatus = status;
    }

    public Integer getPrepareTime() {
        return prepareTime;
    }

    public void setPrepareTime(Integer prepareTime) {
        this.prepareTime = prepareTime;
    }

}
