package com.example.carikado.main.giftinfo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Province implements Serializable {

    private Integer id;
    private String name;
    private Country country;
    private List<City> cities = new ArrayList<>();

    public Province() {

    }

    public Province(String name) {
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void addCity(City city) {
        cities.add(city);
        city.setProvince(this);
    }

    public void removeCity(City city) {
        cities.remove(city);
        city.setProvince(null);
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
