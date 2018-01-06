package com.example.carikado.main.findgift.datasource;

import android.support.annotation.NonNull;

/**
 * Merupakan class yang melakukan akses data
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 26 Desember 2017
 */
public class GenderRepository implements GenderDataSource {
    
    private static GenderRepository sInstance = null;

    private GenderDataSource mGenderDataSource;

    private GenderRepository(GenderDataSource genderDataSource) {
        mGenderDataSource = genderDataSource;
    }

    public static GenderRepository getInstance(GenderDataSource genderDataSource) {
        if (sInstance == null)
            sInstance = new GenderRepository(genderDataSource);

        return sInstance;
    }

    @Override
    public void loadGenders(@NonNull LoadGendersCallback loadGendersCallback) {
        mGenderDataSource.loadGenders(loadGendersCallback);
    }
}
