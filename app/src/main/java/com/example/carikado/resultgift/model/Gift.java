package com.example.carikado.resultgift.model;

import com.example.carikado.main.giftinfo.model.GiftInfoCategory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Gift implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private String link;
    private String gender;
    private Integer ageFrom;
    private Integer ageTo;
    private Integer price;
    private Integer rating;
    private String store;
    private List<GiftPicture> giftPictures = new ArrayList<>();
    private List<GiftInfoCategory> giftInfoCategories = new ArrayList<>();

    public Gift() {

    }

    public Gift(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(Integer ageFrom) {
        this.ageFrom = ageFrom;
    }

    public Integer getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(Integer ageTo) {
        this.ageTo = ageTo;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public void addGiftPicture(GiftPicture giftPicture) {
        giftPictures.add(giftPicture);
    }

    public void removeGiftPicture(GiftPicture giftPicture) {
        giftPictures.remove(giftPicture);
    }

    public List<GiftPicture> getGiftPictures() {
        return giftPictures;
    }

    public void addGiftInfoCategory(GiftInfoCategory giftInfoCategory) {
        giftInfoCategories.add(giftInfoCategory);
    }

    public void removeGiftInfoCategory(GiftInfoCategory giftInfoCategory) {
        giftInfoCategories.remove(giftInfoCategory);
    }

    public List<GiftInfoCategory> getGiftInfoCategories() {
        return giftInfoCategories;
    }
}
