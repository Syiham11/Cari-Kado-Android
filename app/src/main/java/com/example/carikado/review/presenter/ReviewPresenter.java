package com.example.carikado.review.presenter;

import com.example.carikado.review.contract.ReviewContract;

/**
 * Merupakan presenter yang mengatur logic dari review
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 11 Oktober 2017
 */
public class ReviewPresenter implements ReviewContract.Presenter {

    private ReviewContract.View mView;

    public ReviewPresenter(ReviewContract.View view) {
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
    public void submitReview() {
        // TODO masukkan 1 parameter model
        // TODO pengecekan setiap inputan
        // TODO simpan review ke repository

        mView.showSubmitAlert("Berhasil menambahkan review");
    }
}
