package com.example.carikado.splashscreen.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.carikado.R;
import com.example.carikado.main.view.MainActivity;
import com.example.carikado.splashscreen.contract.SplashContract;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;


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
     * Merupakan object dari icon yang akan menampilkan animasi
     */
    @BindView(R.id.iv_icon)
    public ImageView mIvIcon;

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
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.splash_fragment, container, false);
        ButterKnife.bind(this, view);

        view.setOnClickListener(new ViewClickListener());

        try {
            InputStream inputStream = getContext().getAssets().open("ic_splash.gif");
            byte[] bytes = IOUtils.toByteArray(inputStream);

            Glide.with(this)
                    .asGif()
                    .load(bytes)
                    .into(mIvIcon);
        } catch (IOException e) {
            Log.e("Animation Exception", e.getMessage());
        }

        return view;
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
    public void showSplashAnimation() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (getActivity() != null)
                    mSplashPresenter.openMainActivity();
            }
        }, 7500);
    }

    @Override
    public void showMainActivity() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    private class ViewClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            mSplashPresenter.openMainActivity();
        }
    }
}
