package com.example.carikado.util;

import android.content.Context;
import android.support.annotation.NonNull;

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
}
