package com.example.carikado.main.review.presenter;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.carikado.base.model.MyResponse;
import com.example.carikado.main.review.contract.ReviewContract;
import com.example.carikado.main.review.datasource.ReviewDataSource;
import com.example.carikado.main.review.datasource.ReviewRepository;
import com.example.carikado.main.review.model.Review;

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
        boolean isValid = !checkReviewNameIsEmpty(review.getName()) &&
                !checkReviewEmailIsEmpty(review.getEmail()) &&
                !checkReviewCommentIsEmpty(review.getComment()) &&
                !checkReviewRatingIsEmpty(review.getRating());

        if (isValid)
            addReview(review);
    }

    private boolean checkReviewNameIsEmpty(String reviewName) {
        boolean isEmpty = TextUtils.isEmpty(reviewName);

        if (isEmpty)
            mView.showNameEmpty();
        else
            mView.hideNameEmpty();

        return isEmpty;
    }

    private boolean checkReviewEmailIsEmpty(String reviewEmail) {
        boolean isEmpty = TextUtils.isEmpty(reviewEmail);

        if (isEmpty)
            mView.showEmailEmpty();
        else
            mView.hideEmailEmpty();

        return isEmpty;
    }

    private boolean checkReviewCommentIsEmpty(String reviewComment) {
        boolean isEmpty = TextUtils.isEmpty(reviewComment);

        if (isEmpty)
            mView.showCommentEmpty();
        else
            mView.hideCommentEmpty();

        return isEmpty;
    }

    private boolean checkReviewRatingIsEmpty(int reviewRating) {
        boolean isEmpty = reviewRating == 0;

        if (isEmpty)
            mView.showStarsEmpty();

        return isEmpty;
    }

    private void addReview(@NonNull Review review) {
        mView.showProgressDialog();
        mReviewRepository.addReview(review, new ReviewDataSource.AddReviewCallback() {

            @Override
            public void onAddSuccess(@NonNull MyResponse response, @NonNull Boolean isFinish) {
                if (mView.getContextView() != null) {
                    mView.hideProgressDialog();
                    mView.showSubmitAlert(response.getMessage(), isFinish);
                }
            }

            @Override
            public void onAddFailed(@NonNull String message) {
                if (mView.getContextView() != null) {
                    mView.hideProgressDialog();
                    mView.showSubmitAlert(message, false);
                }
            }
        });
    }
}
