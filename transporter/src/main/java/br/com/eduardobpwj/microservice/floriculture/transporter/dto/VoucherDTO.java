package br.com.eduardobpwj.microservice.floriculture.transporter.dto;

import java.time.LocalDate;

public class VoucherDTO {

    private Long number;

    private LocalDate deliveryForecast;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public LocalDate getDeliveryForecast() {
        return deliveryForecast;
    }

    public void setDeliveryForecast(LocalDate deliveryForecast) {
        this.deliveryForecast = deliveryForecast;
    }
}
