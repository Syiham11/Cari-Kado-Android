package com.example.carikado.main.giftinfo.model;

import java.io.Serializable;

public class UserAddress implements Serializable {

    private Integer id;
    private String street;
    private Integer hamlet;
    private Integer neighbourhood;
    private Country country;
    private Province province;
    private City city;
    private District district;
    private SubDistrict subDistrict;

    public UserAddress() {

    }

    public UserAddress(String street, Integer hamlet, Integer neighbourhood) {
        this.street = street;
        this.hamlet = hamlet;
        this.neighbourhood = neighbourhood;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHamlet() {
        return hamlet;
    }

    public void setHamlet(Integer hamlet) {
        this.hamlet = hamlet;
    }

    public Integer getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(Integer neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public SubDistrict getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(SubDistrict subDistrict) {
        this.subDistrict = subDistrict;
    }
}
