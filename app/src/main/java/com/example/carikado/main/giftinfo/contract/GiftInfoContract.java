package com.example.carikado.main.giftinfo.contract;

import android.support.annotation.NonNull;

import com.example.carikado.base.BasePresenter;
import com.example.carikado.base.BaseView;
import com.example.carikado.main.giftinfo.model.GiftInfo;

import java.util.List;

/**
 * Contract untuk mengatur view dan presenter pada giftinfo
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 9 Oktober 2017
 */
public interface GiftInfoContract {

    interface View extends BaseView<Presenter> {

        void showFirstGiftInfos();
        void notifyAdapter();
        void showToastMessage(@NonNull String message);
        void showReview();
        void showGiftInfoDetail(@NonNull GiftInfo giftInfo);
    }

    interface Presenter extends BasePresenter {

        void loadFirstGiftInfos(@NonNull List giftInfoList);
        void loadNextGiftInfos(@NonNull List giftInfoList);
        void openReview();
        void openGiftInfoDetail(@NonNull GiftInfo giftInfo);
    }
}
