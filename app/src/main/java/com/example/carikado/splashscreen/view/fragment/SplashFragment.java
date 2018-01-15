package com.example.carikado.splashscreen.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carikado.R;
import com.example.carikado.main.view.MainActivity;
import com.example.carikado.splashscreen.contract.SplashContract;

/**
 * Fragment untuk splashscreen
 *
 * @author Faza Zulfika P P
 * @author Nindy Ilhami
 * @version 1.1
 * @since 8 Oktober 2017
 */
public class SplashFragment extends Fragment implements SplashContract.View {

    /**
     * Merupakan object dari presenter
     */
    private SplashContract.Presenter mSplashPresenter;

    /**
     * Merupakan constructor kosong yang menjadi default constructor
     */
    public SplashFragment() {
        // Default constructor
    }

    /**
     * Merupakan method yang akan membuat instance / object baru dari view
     *
     * @return merupakan instance / object baru dari view splash
     */
    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.splash_fragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        mSplashPresenter.onStart();
    }

    @Override
    public void setPresenter(@NonNull SplashContract.Presenter presenter) {
        mSplashPresenter = presenter;
    }

    @Override
    public Context getContextView() {
        return getContext();
    }

    @Override
    public void sleepSplashScreen() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (getActivity() != null)
                    mSplashPresenter.openMainActivity();
            }
        }, 1500);
    }

    @Override
    public void showMainActivity() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
