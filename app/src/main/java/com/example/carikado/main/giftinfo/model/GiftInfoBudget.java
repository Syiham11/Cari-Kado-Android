package com.example.carikado.main.giftinfo.model;

import java.io.Serializable;

public class GiftInfoBudget implements Serializable {

    private int id;
    private String from;
    private String to;

    public GiftInfoBudget() {

    }

    public GiftInfoBudget(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
