package com.example.carikado.giftinfodetail.contract;

import android.support.annotation.NonNull;

import com.example.carikado.base.BasePresenter;
import com.example.carikado.base.BaseView;
import com.example.carikado.main.giftinfo.model.GiftInfo;
import com.example.carikado.main.giftinfo.model.GiftInfoCategory;

import java.util.List;

/**
 * Merupakan contract yang mengatur hubungan antara view dan presenter pada gift info detail
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 11 Oktober 2017
 */
public interface GiftInfoDetailContract {

    interface View extends BaseView<Presenter> {

        void showDetail(@NonNull GiftInfo giftInfo);
        void showDetailImages(@NonNull List images);
        void showDetailCategory(@NonNull List<GiftInfoCategory> categories);
    }

    interface Presenter extends BasePresenter {

        void onStart(@NonNull GiftInfo giftInfo);
    }
}
