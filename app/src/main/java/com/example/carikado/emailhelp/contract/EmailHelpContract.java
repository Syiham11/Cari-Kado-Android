package com.example.carikado.emailhelp.contract;

import android.support.annotation.NonNull;

import com.example.carikado.base.BasePresenter;
import com.example.carikado.base.BaseView;
import com.example.carikado.emailhelp.model.EmailHelp;

/**
 * Merupakan contract yang mengatur hubungan antara view dan presenter pada email help
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 13 Oktober 2017
 */
public interface EmailHelpContract {

    interface View extends BaseView<Presenter> {

        void showEmailSubjectEmpty();
        void hideEmailSubjectEmpty();
        void showEmailContentEmpty();
        void hideEmailContentEmpty();
        void showEmailApplication(@NonNull EmailHelp emailHelp);
        void clearAllContent();
    }

    interface Presenter extends BasePresenter {

        void sendEmailHelp(@NonNull EmailHelp emailHelp);
    }
}
