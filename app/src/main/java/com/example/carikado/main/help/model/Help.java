package com.example.carikado.main.help.model;

/**
 * Merupakan model untuk menyimpan data help
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 11 Oktober 2017
 */
public class Help {

    private String mName;
    private String mDesc;
    private int mImageSmall;
    private int mImageBig;
    private int mColor;
    private boolean mIsActive;

    public Help() {
        // Default constructor
    }

    public Help(String name, String desc, int imageSmall, int imageBIg, int color, boolean isActive) {
        mName = name;
        mDesc = desc;
        mImageSmall = imageSmall;
        mImageBig = imageBIg;
        mColor = color;
        mIsActive = isActive;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }

    public int getImageSmall() {
        return mImageSmall;
    }

    public void setImageSmall(int imageSmall) {
        mImageSmall = imageSmall;
    }

    public int getImageBig() {
        return mImageBig;
    }

    public void setImageBig(int imageBig) {
        mImageBig = imageBig;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }

    public boolean isActive() {
        return mIsActive;
    }

    public void setIsActive(boolean isActive) {
        mIsActive = isActive;
    }
}
