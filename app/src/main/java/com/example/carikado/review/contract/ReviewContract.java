package com.example.carikado.review.contract;

import android.support.annotation.NonNull;

import com.example.carikado.base.BasePresenter;
import com.example.carikado.base.BaseView;

/**
 * Merupakan contract yang mengatur hubungan view dan presenter review
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public interface ReviewContract {

    interface View extends BaseView<Presenter> {

        void showNameEmpty();
        void hideNameEmpty();
        void showEmailEmpty();
        void hideEmailEmpty();
        void showCommentEmpty();
        void hideCommentEmpty();
        void showStarsEmpty();
        void showSubmitAlert(@NonNull String message);
    }

    interface Presenter extends BasePresenter {

        void submitReview(); // TODO masukkan parameter model
    }
}
