package com.example.carikado.main.giftinfo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class District implements Serializable {

    private Integer id;
    private String name;
    private City city;
    private List<SubDistrict> subDistricts = new ArrayList<>();

    public District() {

    }

    public District(String name) {
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void addSubDistrict(SubDistrict subDistrict) {
        subDistricts.add(subDistrict);
        subDistrict.setDistrict(this);
    }

    public void removeSubDistrict(SubDistrict subDistrict) {
        subDistricts.remove(subDistrict);
        subDistrict.setDistrict(null);
    }

    public List<SubDistrict> getSubDistricts() {
        return subDistricts;
    }

    public void setSubDistricts(List<SubDistrict> subDistricts) {
        this.subDistricts = subDistricts;
    }
}
