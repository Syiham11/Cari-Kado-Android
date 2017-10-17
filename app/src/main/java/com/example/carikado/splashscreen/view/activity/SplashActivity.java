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

    /**
     * Merupakan method yang dijalankan saat activity dalam fase onCreate
     *
     * @param savedInstanceState merupakan object yang menyimpan state activity ini sebelumnya
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        // Membuat view dan menampilkannya di activity
        SplashFragment splashFragment = SplashFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), splashFragment, R.id.fl_splash);

        // Membuat presenter
        new SplashPresenter(splashFragment);
    }
}
