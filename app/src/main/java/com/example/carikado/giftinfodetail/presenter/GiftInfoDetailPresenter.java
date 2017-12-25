package com.example.carikado.giftinfodetail.presenter;

import android.support.annotation.NonNull;

import com.example.carikado.giftinfodetail.contract.GiftInfoDetailContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Merupakan presenter yang mengatur logic dari gift info detail
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 11 Oktober 2017
 */
public class GiftInfoDetailPresenter implements GiftInfoDetailContract.Presenter {

    private GiftInfoDetailContract.View mView;

    public GiftInfoDetailPresenter(GiftInfoDetailContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void onCreate() {
        // DO nothing
    }

    @Override
    public void onStart() {
        // DO nothing
    }

    @Override
    public void onStart(@NonNull List giftInfoCategories) {

        // TODO masukkan parameter model

        ArrayList<String> model = new ArrayList<>();

        mView.showDetail();
        mView.showDetailImages(model); // TODO ambil list image dari model
        mView.showDetailCategory(giftInfoCategories); // TODO ambil list category dari model
    }

    @Override
    public void onResume() {
        // DO nothing
    }

    @Override
    public void onPause() {
        // DO nothing
    }

    @Override
    public void onStop() {
        // DO nothing
    }

    @Override
    public void onDestroy() {
        // DO nothing
    }
}
