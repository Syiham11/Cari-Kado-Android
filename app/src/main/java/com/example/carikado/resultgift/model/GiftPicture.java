package com.example.carikado.resultgift.model;

import java.io.Serializable;

public class GiftPicture implements Serializable {

    private Integer id;
    private String url;

    public GiftPicture() {

    }

    public GiftPicture(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
