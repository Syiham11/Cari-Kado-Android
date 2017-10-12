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

    private final SplashContract.View mSplashView;

    public SplashPresenter(@NonNull SplashContract.View splashView) {
        mSplashView = splashView;
        mSplashView.setPresenter(this);
    }

    @Override
    public void onCreate() {
        // Do nothing
    }

    @Override
    public void onStart() {
        mSplashView.showSplashAnimation();
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

    @Override
    public void openMainActivity() {
        mSplashView.showMainActivity();
    }
}
