package com.example.carikado.util;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.carikado.main.findgift.datasource.GenderDataSource;
import com.example.carikado.main.findgift.datasource.GenderRepository;
import com.example.carikado.main.findgift.datasource.GiftInfoCategoryRepository;
import com.example.carikado.main.findgift.datasource.local.GenderLocalDataSource;
import com.example.carikado.main.findgift.datasource.remote.GiftInfoCategoryRemoteDataSource;
import com.example.carikado.main.giftinfo.datasource.GiftInfoRepository;
import com.example.carikado.main.giftinfo.datasource.remote.GiftInfoRemoteDataSource;
import com.example.carikado.resultgift.datasource.GiftRepository;
import com.example.carikado.resultgift.datasource.remote.GiftRemoteDataSource;
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

    public static ReviewRepository provideReviewRepository(@NonNull Context context) {
        return ReviewRepository.getInstance(ReviewRemoteDataSource.getInstance(context));
    }

    public static GiftInfoRepository provideGiftInfoRepository(@NonNull Context context) {
        return GiftInfoRepository.getInstance(GiftInfoRemoteDataSource.getInstance(context));
    }

    public static GiftInfoCategoryRepository provideGiftInfoCategoryRepository(@NonNull Context context) {
        return GiftInfoCategoryRepository.getInstance(GiftInfoCategoryRemoteDataSource.getInstance(context));
    }

    public static GenderRepository provideGenderRepository(@NonNull Context context) {
        return GenderRepository.getInstance(GenderLocalDataSource.getInstance(context));
    }

    public static GiftRepository provideGiftRepository(@NonNull Context context) {
        return GiftRepository.getInstance(GiftRemoteDataSource.getInstance(context));
    }
}
