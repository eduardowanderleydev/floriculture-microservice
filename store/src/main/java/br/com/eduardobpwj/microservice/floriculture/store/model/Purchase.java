package br.com.eduardobpwj.microservice.floriculture.store.model;

import br.com.eduardobpwj.microservice.floriculture.store.enumerated.PurchaseState;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idOrder;

    private Integer prepareTime;

    private String targetAddress;

    private LocalDate deliveryForecast;

    private Long voucher;

    @Enumerated(EnumType.STRING)
    private PurchaseState state;

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getPrepareTime() {
        return prepareTime;
    }

    public void setPrepareTime(Integer prepareTime) {
        this.prepareTime = prepareTime;
    }

    public String getTargetAddress() {
        return targetAddress;
    }

    public void setTargetAddress(String targetAddress) {
        this.targetAddress = targetAddress;
    }

    public void setDeliveryForecast(LocalDate deliveryForecast) {
        this.deliveryForecast = deliveryForecast;
    }

    public LocalDate getDeliveryForecast() {
        return deliveryForecast;
    }

    public void setVoucher(Long voucher) {
        this.voucher = voucher;
    }

    public Long getVoucher() {
        return voucher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setState(PurchaseState state) {
        this.state = state;
    }

    public PurchaseState getState() {
        return state;
    }
}
