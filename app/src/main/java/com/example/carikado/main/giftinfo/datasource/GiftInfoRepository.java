package com.example.carikado.main.giftinfo.datasource;

import android.support.annotation.NonNull;

import java.util.HashMap;

/**
 * Merupakan class yang melakukan akses data
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 20 Desember 2017
 */
public class GiftInfoRepository implements GiftInfoDataSource {

    private static GiftInfoRepository sInstance = null;

    private GiftInfoDataSource mGiftInfoDataSource;

    private GiftInfoRepository(GiftInfoDataSource giftInfoDataSource) {
        mGiftInfoDataSource = giftInfoDataSource;
    }

    public static GiftInfoRepository getInstance(GiftInfoDataSource giftInfoDataSource) {
        if (sInstance == null)
            sInstance = new GiftInfoRepository(giftInfoDataSource);

        return sInstance;
    }

    @Override
    public void loadGiftInfos(@NonNull Integer page, @NonNull Integer pageSize, @NonNull Integer sort, @NonNull LoadGiftInfosCallback loadGiftInfosCallback) {
        mGiftInfoDataSource.loadGiftInfos(page, pageSize, sort, loadGiftInfosCallback);
    }
}
