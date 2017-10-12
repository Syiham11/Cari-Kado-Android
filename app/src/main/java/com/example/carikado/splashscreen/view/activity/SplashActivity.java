package com.example.carikado.splashscreen.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.carikado.R;
import com.example.carikado.splashscreen.presenter.SplashPresenter;
import com.example.carikado.splashscreen.view.fragment.SplashFragment;
import com.example.carikado.util.ActivityUtils;

/**
 * Merupakan tampilan awal pada saat aplikasi dibuka
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 25 September 2017
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        // Create fragment and add it to activity
        SplashFragment splashFragment = SplashFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), splashFragment, R.id.fl_splash);

        // Create the presenter
        SplashPresenter splashPresenter = new SplashPresenter(splashFragment);
    }
}
