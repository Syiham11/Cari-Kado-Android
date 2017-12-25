package com.example.carikado.main.giftinfo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class City implements Serializable {

    private Integer id;
    private String name;
    private Province province;
    private List<District> districts = new ArrayList<>();

    public City() {

    }

    public City(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public void addDistrict(District district) {
        districts.add(district);
        district.setCity(this);
    }

    public void removeDistrict(District district) {
        districts.remove(district);
        district.setCity(null);
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }
}
