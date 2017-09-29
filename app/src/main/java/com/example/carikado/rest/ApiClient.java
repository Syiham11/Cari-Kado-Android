package com.example.carikado.rest;

import android.content.Context;

import com.example.carikado.R;

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

    public static Retrofit getClient(Context context) {
        String baseUrl = context.getString(R.string.base_url);

        if (retrofit == null)
            retrofit = initializeClient(baseUrl);

        return retrofit;
    }

    private static Retrofit initializeClient(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
