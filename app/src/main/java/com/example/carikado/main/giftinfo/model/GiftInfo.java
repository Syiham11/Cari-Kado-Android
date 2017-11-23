package com.example.carikado.main.giftinfo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GiftInfo implements Serializable {

    private int id;
    private String title;
    private String description;
    private String essence;
    private Date createdAt;
//    private User user;
    private GiftInfoAge giftInfoAge;
    private List<GiftInfoCategory> giftInfoCategories = new ArrayList<>();
    private GiftInfoBudget giftInfoBudget;

    public GiftInfo() {

    }

    public GiftInfo(String title, String description, String essence) {
        this.title = title;
        this.description = description;
        this.essence = essence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEssence() {
        return essence;
    }

    public void setEssence(String essence) {
        this.essence = essence;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public GiftInfoAge getGiftInfoAge() {
        return giftInfoAge;
    }

    public void setGiftInfoAge(GiftInfoAge giftInfoAge) {
        this.giftInfoAge = giftInfoAge;
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

    public GiftInfoBudget getGiftInfoBudget() {
        return giftInfoBudget;
    }

    public void setGiftInfoBudget(GiftInfoBudget giftInfoBudget) {
        this.giftInfoBudget = giftInfoBudget;
    }
}
