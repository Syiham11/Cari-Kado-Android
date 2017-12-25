package com.example.carikado.main.giftinfo.model;

import java.io.Serializable;

public class UserName implements Serializable {

    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;

    public UserName() {

    }

    public UserName(String firstName, String lastName) {
        this(firstName, null, lastName);
    }

    public UserName(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
