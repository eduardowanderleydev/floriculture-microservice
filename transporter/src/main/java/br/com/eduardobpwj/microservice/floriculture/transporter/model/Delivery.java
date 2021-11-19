package br.com.eduardobpwj.microservice.floriculture.transporter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    private LocalDate deliveryDate;

    private LocalDate deliveryForecast;

    private String sourceAddress;

    private String targetAddress;

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate dataParaBusca) {
        this.deliveryDate = dataParaBusca;
    }

    public LocalDate getDeliveryForecast() {
        return deliveryForecast;
    }

    public void setDeliveryForecast(LocalDate previsaoParaEntrega) {
        this.deliveryForecast = previsaoParaEntrega;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String enderecoOrigem) {
        this.sourceAddress = enderecoOrigem;
    }

    public String getTargetAddress() {
        return targetAddress;
    }

    public void setTargetAddress(String enderecoDestino) {
        this.targetAddress = enderecoDestino;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long pedidoId) {
        this.orderId = pedidoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
