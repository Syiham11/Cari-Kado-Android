package com.example.carikado.resultgift.datasource;

import android.support.annotation.NonNull;

import com.example.carikado.main.findgift.model.Search;

/**
 * Merupakan class yang melakukan akses data
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 27 Desember 2017
 */
public class GiftRepository implements GiftDataSource {

    private static GiftRepository sInstance = null;

    private GiftDataSource mGiftDataSource;

    private GiftRepository(GiftDataSource GiftDataSource) {
        mGiftDataSource = GiftDataSource;
    }

    public static GiftRepository getInstance(GiftDataSource GiftDataSource) {
        if (sInstance == null)
            sInstance = new GiftRepository(GiftDataSource);

        return sInstance;
    }

    @Override
    public void loadGifts(@NonNull Integer page, @NonNull Integer pageSize, @NonNull Integer sort, @NonNull Search search, @NonNull LoadGiftsCallback loadGiftsCallback) {
        mGiftDataSource.loadGifts(page, pageSize, sort, search, loadGiftsCallback);
    }
}
