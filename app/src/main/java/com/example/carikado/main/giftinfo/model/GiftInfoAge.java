package com.example.carikado.main.giftinfo.model;

import java.io.Serializable;

public class GiftInfoAge implements Serializable {

    private int id;
    private Integer from;
    private Integer to;

    public GiftInfoAge() {

    }

    public GiftInfoAge(Integer from, Integer to) {
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
