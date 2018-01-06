package com.example.carikado.main.giftinfo.model;

import java.io.Serializable;

public class GiftInfoBudget implements Serializable {

    private int id;
    private Integer from;
    private Integer to;

    public GiftInfoBudget() {

    }

    public GiftInfoBudget(Integer from, Integer to) {
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }
}
