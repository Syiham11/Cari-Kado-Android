package com.example.carikado.main.giftinfo.model;

import java.io.Serializable;

public class SubDistrict implements Serializable {

    private Long id;
    private String name;
    private District district;

    public SubDistrict() {

    }

    public SubDistrict(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
