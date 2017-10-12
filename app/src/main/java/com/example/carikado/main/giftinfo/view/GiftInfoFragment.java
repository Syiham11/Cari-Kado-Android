package com.example.carikado.main.giftinfo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.carikado.giftinfodetail.view.activity.GiftInfoDetailActivity;
import com.example.carikado.main.giftinfo.adapter.GiftInfoAdapter;
import com.example.carikado.R;
import com.example.carikado.main.giftinfo.contract.GiftInfoContract;
import com.example.carikado.review.view.activity.ReviewActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Merupakan tampilan untuk mencari informasi tentang kado-kado
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 25 September 2017
 */

public class GiftInfoFragment extends Fragment implements GiftInfoContract.View {

    @BindView(R.id.rv_gift_info)
    public RecyclerView mRvGiftInfo;

    @BindView(R.id.tb_gift_info)
    public Toolbar mTbGiftInfo;

    private ArrayList<String> mGiftInfos;
    private GiftInfoAdapter mGiftInfoAdapter;
    private GiftInfoContract.Presenter mGiftInfoPresenter;

    public GiftInfoFragment() {
        // Default constructor
    }

    public static GiftInfoFragment newInstance() {
        return new GiftInfoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gift_info_fragment, container, false);
        ButterKnife.bind(this, view);

        mTbGiftInfo.setTitle("");
        ((AppCompatActivity) getActivity()).setSupportActionBar(mTbGiftInfo);

        mRvGiftInfo.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvGiftInfo.setHasFixedSize(true);
        mRvGiftInfo.setNestedScrollingEnabled(false);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.gift_info_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.menu_review:
                mGiftInfoPresenter.openReview();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mGiftInfoPresenter.onResume();
    }

    @Override
    public void setPresenter(@NonNull GiftInfoContract.Presenter presenter) {
        mGiftInfoPresenter = presenter;
    }

    @Override
    public void showGiftInfos() {
        if (mGiftInfos == null)
            mGiftInfos = new ArrayList<>();

        mGiftInfos.add("Teddy Bear");
        mGiftInfos.add("Kaca Mata");
        mGiftInfos.add("Bunga Mawar");
        mGiftInfos.add("Bunga Melati");
        mGiftInfos.add("Teddy Bear");
        mGiftInfos.add("Kaca Mata");
        mGiftInfos.add("Bunga Mawar");
        mGiftInfos.add("Bunga Melati");

        mGiftInfoPresenter.loadGiftInfos(mGiftInfos);

        if (mGiftInfoAdapter == null)
            mGiftInfoAdapter = new GiftInfoAdapter(getContext(), mGiftInfos, mGiftInfoPresenter);
        mRvGiftInfo.setAdapter(mGiftInfoAdapter);
    }

    @Override
    public void showReview() {
        Intent intent = new Intent(getContext(), ReviewActivity.class);
        startActivity(intent);
    }

    @Override
    public void showGiftInfoDetail(@NonNull String s) {
        Intent intent = new Intent(getContext(), GiftInfoDetailActivity.class);
        intent.putExtra("Gift Info", s);

        startActivity(intent);
    }
}
