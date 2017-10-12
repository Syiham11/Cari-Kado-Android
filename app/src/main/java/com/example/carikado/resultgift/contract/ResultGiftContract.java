package com.example.carikado.resultgift.contract;

import android.support.annotation.NonNull;

import com.example.carikado.base.BasePresenter;
import com.example.carikado.base.BaseView;

import java.util.List;

/**
 * Merupakan contract yang mengatur hubungan antara view dan prsenter pada result gift
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 11 Oktober 2017
 */
public interface ResultGiftContract {

    interface View extends BaseView<Presenter> {

        void showGifts();
        void showGiftDetail(); // TODO tambahkan parameter model
    }

    interface Presenter extends BasePresenter {

        void loadGifts(@NonNull List gifts);
        void searchGift(@NonNull String name);
        void openGiftDetail(); // TODO tambahkan parameter model
    }
}
