package com.example.carikado.resultgift.contract;

import android.support.annotation.NonNull;

import com.example.carikado.base.BasePresenter;
import com.example.carikado.base.BaseView;
import com.example.carikado.main.findgift.model.Search;
import com.example.carikado.resultgift.model.Gift;

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

        void showFirstGifts();
        void notifyGifts();
        void showResultGifts();
        void hideResultGifts();
        void showToastMessage(@NonNull String message);
        void showGiftDetail(@NonNull Gift gift);
    }

    interface Presenter extends BasePresenter {

        void loadFirstGifts(@NonNull Search search,
                            @NonNull List gifts);
        void loadNextGifts(@NonNull Search search,
                           @NonNull List gifts);
        void showResultGifts();
        void hideResultGifts();
        void searchGift(@NonNull String name);
        void openGiftDetail(@NonNull Gift gift);
    }
}
