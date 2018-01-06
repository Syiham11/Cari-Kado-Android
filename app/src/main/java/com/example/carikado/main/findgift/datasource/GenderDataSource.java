package com.example.carikado.main.findgift.datasource;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Merupakan class yang mengatur pengaksesan data
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 26 Desember 2017
 */
public interface GenderDataSource {

    interface LoadGendersCallback {

        void onLoadSuccess(@NonNull List genders);
        void onLoadFailed(@NonNull String message);
    }

    void loadGenders(@NonNull GenderDataSource.LoadGendersCallback loadGendersCallback);
}
