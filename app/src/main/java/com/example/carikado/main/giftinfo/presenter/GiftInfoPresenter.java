package com.example.carikado.main.giftinfo.presenter;

import android.support.annotation.NonNull;

import com.example.carikado.main.giftinfo.contract.GiftInfoContract;
import com.example.carikado.main.giftinfo.model.GiftInfo;

import java.util.List;

/**
 * Merupakan presenter untuk mencari info kado
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 9 Oktober 2017
 */
public class GiftInfoPresenter implements GiftInfoContract.Presenter {

    private final GiftInfoContract.View mView;

    public GiftInfoPresenter(GiftInfoContract.View view) {
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
        mView.showGiftInfos();
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
    public void loadGiftInfos(@NonNull List giftInfoList) {
        // TODO load gift info from repository
    }

    @Override
    public void openReview() {
        mView.showReview();
    }

    @Override
    public void openGiftInfoDetail(@NonNull GiftInfo giftInfo) {
        mView.showGiftInfoDetail(giftInfo);
    }
}
