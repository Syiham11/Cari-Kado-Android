package com.example.carikado.rest;

import android.content.Context;

import com.example.carikado.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class yang mengatur pembuatan object retrofit untuk mengatur rest service aplikasi
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 29 September 2017
 */
public class ApiClient {

    private static Retrofit retrofit = null;

    private static Retrofit getClient(Context context) {
        String baseUrl = context.getString(R.string.base_url);

        if (retrofit == null)
            retrofit = initializeClient(baseUrl);

        return retrofit;
    }

    private static Retrofit initializeClient(String baseUrl) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static ApiInterface getApiInterface(Context context) {
        return getClient(context).create(ApiInterface.class);
    }
}
