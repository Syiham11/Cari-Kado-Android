package com.example.carikado.giftinfodetail.presenter;

import android.support.annotation.NonNull;

import com.example.carikado.giftinfodetail.contract.GiftInfoDetailContract;
import com.example.carikado.main.giftinfo.model.GiftInfo;

import java.util.ArrayList;

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
    public void onStart(@NonNull GiftInfo giftInfo) {
        ArrayList<String> model = new ArrayList<>();

        mView.showDetail(giftInfo);
        mView.showDetailImages(model); // TODO ambil list image dari model
        mView.showDetailCategory(giftInfo.getGiftInfoCategories());
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
