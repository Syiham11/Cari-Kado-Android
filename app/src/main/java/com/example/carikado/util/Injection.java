package com.example.carikado.util;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.carikado.main.findgift.datasource.GiftInfoCategoryRepository;
import com.example.carikado.main.findgift.datasource.remote.GiftInfoCategoryRemoteDataSource;
import com.example.carikado.main.giftinfo.datasource.GiftInfoRepository;
import com.example.carikado.main.giftinfo.datasource.remote.GiftInfoRemoteDataSource;
import com.example.carikado.review.datasource.ReviewRepository;
import com.example.carikado.review.datasource.remote.ReviewRemoteDataSource;

/**
 * Merupakan class untuk menginject repository yang dibutuhkan
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 13 Oktober 2017
 */
public class Injection {

    public static ReviewRepository proviceReviewRepository(@NonNull Context context) {
        return ReviewRepository.getInstance(ReviewRemoteDataSource.getInstance(context));
    }

    public static GiftInfoRepository proviceGiftInfoRepository(@NonNull Context context) {
        return GiftInfoRepository.getInstance(GiftInfoRemoteDataSource.getInstance(context));
    }

    public static GiftInfoCategoryRepository proviceGiftInfoCategoryRepository(@NonNull Context context) {
        return GiftInfoCategoryRepository.getInstance(GiftInfoCategoryRemoteDataSource.getInstance(context));
    }
}
