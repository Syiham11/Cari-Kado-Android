package com.example.carikado.main.review.datasource;

import android.support.annotation.NonNull;

import com.example.carikado.main.review.datasource.remote.ReviewRemoteDataSource;
import com.example.carikado.main.review.model.Review;

/**
 * Merupakan class yang melakukan akses data
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 13 Oktober 2017
 */
public class ReviewRepository implements ReviewDataSource {

    private static ReviewRepository sInstance = null;

    private ReviewRemoteDataSource mReviewRemoteDataSource;

    private ReviewRepository(ReviewRemoteDataSource reviewRemoteDataSource) {
        mReviewRemoteDataSource = reviewRemoteDataSource;
    }

    public static ReviewRepository getInstance(ReviewRemoteDataSource reviewRemoteDataSource) {
        if (sInstance == null)
            sInstance = new ReviewRepository(reviewRemoteDataSource);

        return sInstance;
    }

    @Override
    public void addReview(@NonNull Review review, @NonNull AddReviewCallback addReviewCallback) {
        mReviewRemoteDataSource.addReview(review, addReviewCallback);
    }
}
