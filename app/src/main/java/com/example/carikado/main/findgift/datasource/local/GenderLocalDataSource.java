package com.example.carikado.main.findgift.datasource.local;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;

import com.example.carikado.R;
import com.example.carikado.main.findgift.datasource.GenderDataSource;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Merupakan class yang melakukan akses data ke local
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 26 Desember 2017
 */
public class GenderLocalDataSource implements GenderDataSource {

    private static GenderLocalDataSource sInstance = null;

    private Context mContext;

    private GenderLocalDataSource(Context context) {
        mContext = context;
    }

    public static GenderLocalDataSource getInstance(Context context) {
        if (sInstance == null)
            sInstance = new GenderLocalDataSource(context);

        return sInstance;
    }
    
    @Override
    public void loadGenders(@NonNull LoadGendersCallback loadGendersCallback) {
        try {
            String[] gendersArray = mContext.getResources().getStringArray(R.array.gender_array);
            ArrayList<String> genders = new ArrayList<>(Arrays.asList(gendersArray));

            loadGendersCallback.onLoadSuccess(genders);
        } catch (Resources.NotFoundException e) {
            String message = mContext.getString(R.string.gender_error);
            loadGendersCallback.onLoadFailed(message);
        }
    }
}
