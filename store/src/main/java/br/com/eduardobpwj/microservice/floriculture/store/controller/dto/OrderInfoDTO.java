package br.com.eduardobpwj.microservice.floriculture.store.controller.dto;

public class OrderInfoDTO {

    private Long id;

    private Integer prepareTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrepareTime() {
        return prepareTime;
    }

    public void setPrepareTime(Integer prepareTime) {
        this.prepareTime = prepareTime;
    }
}
