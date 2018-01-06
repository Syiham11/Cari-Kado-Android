package com.example.carikado.resultgift.datasource;

import android.support.annotation.NonNull;

import com.example.carikado.base.model.MyPage;
import com.example.carikado.main.findgift.model.Search;
import com.example.carikado.resultgift.model.Gift;

import java.util.List;


/**
 * Merupakan class yang mengatur pengaksesan data
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 27 Desember 2017
 */
public interface GiftDataSource {

    interface LoadGiftsCallback {

        void onLoadSuccess(@NonNull MyPage<List<Gift>> giftPages);
        void onLoadFailed(@NonNull String message);
    }

    void loadGifts(@NonNull Integer page,
                   @NonNull Integer pageSize,
                   @NonNull Integer sort,
                   @NonNull Search search,
                   @NonNull GiftDataSource.LoadGiftsCallback loadGiftsCallback);
}
