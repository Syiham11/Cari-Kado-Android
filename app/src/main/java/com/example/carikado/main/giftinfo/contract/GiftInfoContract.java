package com.example.carikado.main.giftinfo.contract;

import android.support.annotation.NonNull;

import com.example.carikado.base.BasePresenter;
import com.example.carikado.base.BaseView;

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

        void showGiftInfos();
        void showReview();
        void showGiftInfoDetail(@NonNull String s); // TODO mengirim parameter model
    }

    interface Presenter extends BasePresenter {

        void loadGiftInfos(@NonNull List giftInfoList);
        void openReview();
        void openGiftInfoDetail(@NonNull String s); // TODO mengirim parameter model
    }
}
