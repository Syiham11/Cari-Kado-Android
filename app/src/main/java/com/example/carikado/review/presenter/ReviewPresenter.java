package com.example.carikado.review.presenter;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.carikado.base.model.MyResponse;
import com.example.carikado.review.contract.ReviewContract;
import com.example.carikado.review.datasource.ReviewDataSource;
import com.example.carikado.review.datasource.ReviewRepository;
import com.example.carikado.review.model.Review;

/**
 * Merupakan presenter yang mengatur logic dari review
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 11 Oktober 2017
 */
public class ReviewPresenter implements ReviewContract.Presenter {

    private ReviewContract.View mView;
    private ReviewRepository mReviewRepository;

    public ReviewPresenter(ReviewRepository reviewRepository, ReviewContract.View view) {
        mReviewRepository = reviewRepository;
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void onCreate() {
        // Do nothing
    }

    @Override
    public void onStart() {
        // Do nothing
    }

    @Override
    public void onResume() {
        // Do nothing
    }

    @Override
    public void onPause() {
        // Do nothing
    }

    @Override
    public void onStop() {
        // Do nothing
    }

    @Override
    public void onDestroy() {
        // Do nothing
    }

    @Override
    public void submitReview(@NonNull Review review) {
        boolean isValid = true;

        mView.showProgressDialog();

        if (TextUtils.isEmpty(review.getName())) {
            mView.showNameEmpty();
            isValid = false;
        } else
            mView.hideNameEmpty();

        if (TextUtils.isEmpty(review.getEmail())) {
            mView.showEmailEmpty();
            isValid = false;
        } else
            mView.hideEmailEmpty();

        if (TextUtils.isEmpty(review.getComment())) {
            mView.showCommentEmpty();
            isValid = false;
        } else
            mView.hideCommentEmpty();

        if (review.getRating() == 0) {
            mView.showStarsEmpty();
            isValid = false;
        }

        if (isValid) {
            mReviewRepository.addReview(review, new ReviewDataSource.AddReviewCallback() {

                @Override
                public void onAddSuccess(@NonNull MyResponse response, @NonNull Boolean isFinish) {
                    mView.showSubmitAlert(response.getMessage(), isFinish);
                }

                @Override
                public void onAddFailed(@NonNull String message) {
                    mView.showSubmitAlert(message, false);
                }
            });
        }

        mView.hideProgressDialog();
    }
}
