package com.example.carikado.main.giftinfo.model;

import java.io.Serializable;

public class UserPicture implements Serializable {

    private Integer id;
    private String name;
    private String type;
    private Integer size;
    private String url;

    public UserPicture() {

    }

    public UserPicture(String name, String type, Integer size, String url) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.url = url;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
