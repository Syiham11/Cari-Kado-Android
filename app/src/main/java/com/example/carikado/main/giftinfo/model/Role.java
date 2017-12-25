package com.example.carikado.main.giftinfo.model;

import java.io.Serializable;

public class Role implements Serializable {

    private Integer id;
    private String name;

    public Role() {

    }

    public Role(String name) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Role) {
            Role role = (Role) obj;

            if (role.getId() != 0)
                return id == role.getId().intValue();
            else
                return name.equals(role.getName());
        } else
            return false;
    }
}
