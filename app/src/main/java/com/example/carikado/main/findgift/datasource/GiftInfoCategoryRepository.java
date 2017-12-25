package com.example.carikado.main.findgift.datasource;

import android.support.annotation.NonNull;

/**
 * Merupakan class yang melakukan akses data
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 20 Desember 2017
 */
public class GiftInfoCategoryRepository implements GiftInfoCategoryDataSource {

    private static GiftInfoCategoryRepository sInstance = null;

    private GiftInfoCategoryDataSource mGiftInfoCategoryDataSource;

    private GiftInfoCategoryRepository(GiftInfoCategoryDataSource giftInfoCategoryDataSource) {
        mGiftInfoCategoryDataSource = giftInfoCategoryDataSource;
    }

    public static GiftInfoCategoryRepository getInstance(GiftInfoCategoryDataSource giftInfoCategoryDataSource) {
        if (sInstance == null)
            sInstance = new GiftInfoCategoryRepository(giftInfoCategoryDataSource);

        return sInstance;
    }

    @Override
    public void loadGiftInfoCategories(@NonNull LoadGiftInfoCategoriessCallback loadGiftInfoCategoriesCallback) {
        mGiftInfoCategoryDataSource.loadGiftInfoCategories(loadGiftInfoCategoriesCallback);
    }
}
