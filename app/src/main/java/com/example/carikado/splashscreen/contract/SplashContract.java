package com.example.carikado.splashscreen.contract;

import com.example.carikado.base.BasePresenter;
import com.example.carikado.base.BaseView;

/**
 * Contract untuk mengatur view dan presenter pada splashscreen
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 8 Oktober 2017
 */
public interface SplashContract {

    interface View extends BaseView<Presenter> {

        void showSplashAnimation();
        void showMainActivity();
    }

    interface Presenter extends BasePresenter {

        void openMainActivity();
    }
}
