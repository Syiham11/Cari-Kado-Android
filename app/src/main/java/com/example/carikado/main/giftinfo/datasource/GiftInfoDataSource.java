package com.example.carikado.main.giftinfo.datasource;

import android.support.annotation.NonNull;

import com.example.carikado.base.model.MyPage;
import com.example.carikado.main.giftinfo.model.GiftInfo;

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

        void onLoadSuccess(@NonNull MyPage<List<GiftInfo>> giftInfoPages);
        void onLoadFailed(@NonNull String message);
    }

    void loadGiftInfos(@NonNull Integer page,
                       @NonNull Integer pageSize,
                       @NonNull Integer sort,
                       @NonNull LoadGiftInfosCallback loadGiftInfosCallback);
}
