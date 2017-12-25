package com.example.carikado.main.giftinfo.datasource;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.List;

/**
 * Merupakan class yang mengatur pengaksesan data
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 18 Oktober 2017
 */
public interface GiftInfoDataSource {

    interface LoadGiftInfosCallback {

        void onLoadSuccess(@NonNull List giftInfos);
        void onLoadFailed(@NonNull String message);
    }

    void loadGiftInfos(@NonNull HashMap<String, Integer> params,
                       @NonNull LoadGiftInfosCallback loadGiftInfosCallback);
}
