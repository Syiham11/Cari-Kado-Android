package com.example.carikado.splashscreen.presenter;

import android.support.annotation.NonNull;

import com.example.carikado.splashscreen.contract.SplashContract;

/**
 * Presenter untuk splashscreen
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 8 Oktober 2017
 */
public class SplashPresenter implements SplashContract.Presenter {

    /**
     * Merupakan object dari view yang terhubung dengan presenter
     */
    private final SplashContract.View mSplashView;

    /**
     * Merupakan default constructor yang pada saat object presenter dibuat, maka akan mengatur
     * agar view memiliki presenter ini
     *
     * @param splashView merupakan view yang akan dihubungkan dengan presenter
     */
    public SplashPresenter(@NonNull SplashContract.View splashView) {
        mSplashView = splashView;
        mSplashView.setPresenter(this);
    }

    @Override
    public void onCreate() {
        // Do nothing
    }

    /**
     * Merupakan method yang dijalankan saat view dalam fase onStart
     * Method ini akan metrigger view untuk menampilkan animasi
     */
    @Override
    public void onStart() {
        mSplashView.sleepSplashScreen();
    }

    @Override
    public void onResume() {
        // Do nothing
    }

    @Override
    public void onPause() {
        // Do nothing
    }

    @Override
    public void onStop() {
        // Do nothing
    }

    @Override
    public void onDestroy() {
        // Do nothing
    }

    /**
     * Method yang digunakan untuk mentrigger view agar menampilkan main activity
     */
    @Override
    public void openMainActivity() {
        mSplashView.showMainActivity();
    }
}
