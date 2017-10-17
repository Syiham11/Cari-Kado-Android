package com.example.carikado.base.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MyResponse<T> implements Serializable {

    @SerializedName("status")
    private String mStatus;

    @SerializedName("message")
    private String mMessage;

    @SerializedName("data")
    private T mData;

    public MyResponse() {

    }

    public MyResponse(String status, String message) {
        this(status, message, null);
    }

    public MyResponse(String status, String message, T data) {
        mStatus = status;
        mMessage = message;
        mData = data;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String mMessage) {
        mMessage = mMessage;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        mData = data;
    }
}
