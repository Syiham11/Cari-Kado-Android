package com.example.carikado.main.findgift.model;

import java.io.Serializable;

/**
 * Model untuk menyimpan data yang digunakan untuk mencari kado
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 4 Januari 2018
 */

public class Search implements Serializable {

    private Integer mAge;
    private String mGender;
    private Integer mBudgetFrom;
    private Integer mBudgetTo;
    private String mCategory;
    private String mName;

    public Search() {

    }

    public Search(Integer age, String gender, Integer budgetFrom, Integer budgetTo, String category) {
        mAge = age;
        mGender = gender;
        mBudgetFrom = budgetFrom;
        mBudgetTo = budgetTo;
        mCategory = category;
    }

    public Integer getAge() {
        return mAge;
    }

    public void setAge(Integer age) {
        mAge = age;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public Integer getBudgetFrom() {
        return mBudgetFrom;
    }

    public void setBudgetFrom(Integer budgetFrom) {
        mBudgetFrom = budgetFrom;
    }

    public Integer getBudgetTo() {
        return mBudgetTo;
    }

    public void setBudgetTo(Integer budgetTo) {
        mBudgetTo = budgetTo;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setmCategory(String category) {
        mCategory = category;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
