package com.example.carikado.resultgift.presenter;

import android.support.annotation.NonNull;

import com.example.carikado.resultgift.contract.ResultGiftContract;

import java.util.List;

/**
 * Merupakan presenter yang mengatur logic dari result gift
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 11 Oktober 2017
 */
public class ResultGiftPresenter implements ResultGiftContract.Presenter {

    private ResultGiftContract.View mView;

    public ResultGiftPresenter(ResultGiftContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void onCreate() {
        // Do nothing
    }

    @Override
    public void onStart() {
        mView.showGifts();
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
    public void loadGifts(@NonNull List gifts) {
        // TODO load gifts data from repository
    }

    @Override
    public void searchGift(@NonNull String name) {
        // TODO Search gift from repository
    }

    @Override
    public void openGiftDetail() {
        // TODO masukkan parameter model
        mView.showGiftDetail();
    }
}
