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

    /**
     * Merupakan interface yang mengatur apa-apa saja event pada view
     */
    interface View extends BaseView<Presenter> {

        /**
         * Merupakan method yang digunakan untuk menampilkan animasi pada splash screen
         */
        void sleepSplashScreen();

        /**
         * Merupakan method yang digunakan untuk menampilkan main activity
         */
        void showMainActivity();
    }

    /**
     * Merupakan interface yang mengatur apa-apa saja event pada presenter
     */
    interface Presenter extends BasePresenter {

        /**
         * Merupakan method yang digunakan untuk mentrigger view agar menampilkan main activity
         */
        void openMainActivity();
    }
}
