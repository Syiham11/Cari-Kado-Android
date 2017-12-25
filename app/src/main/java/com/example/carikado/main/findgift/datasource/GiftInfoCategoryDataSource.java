package com.example.carikado.main.findgift.datasource;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Merupakan class yang mengatur pengaksesan data
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 20 Desember 2017
 */
public interface GiftInfoCategoryDataSource {

    interface LoadGiftInfoCategoriessCallback {

        void onLoadSuccess(@NonNull List giftInfoCategories);
        void onLoadFailed(@NonNull String message);
    }

    void loadGiftInfoCategories(@NonNull GiftInfoCategoryDataSource.LoadGiftInfoCategoriessCallback loadGiftInfoCategoriesCallback);
}
