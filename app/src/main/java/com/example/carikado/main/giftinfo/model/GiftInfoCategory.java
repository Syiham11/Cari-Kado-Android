package com.example.carikado.main.giftinfo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GiftInfoCategory implements Serializable {

    private int id;
    private String name;
    private List<GiftInfo> giftInfos = new ArrayList<>();

    public GiftInfoCategory() {

    }

    public GiftInfoCategory(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGiftInfo(GiftInfo giftInfo) {
        giftInfos.add(giftInfo);
    }

    public void removeGiftInfo(GiftInfo giftInfo) {
        giftInfos.remove(giftInfo);
    }

    public List<GiftInfo> getGiftInfos() {
        return giftInfos;
    }
}
