package br.com.eduardobpwj.microservice.floriculture.store.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Purchase {

    @Id
    private Long idOrder;

    private Integer prepareTime;

    private String targetAddress;

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
}
