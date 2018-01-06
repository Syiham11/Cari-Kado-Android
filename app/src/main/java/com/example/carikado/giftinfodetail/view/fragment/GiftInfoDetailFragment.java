package com.example.carikado.giftinfodetail.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.carikado.R;
import com.example.carikado.giftinfodetail.adapter.GiftInfoDetailCategoryAdapter;
import com.example.carikado.giftinfodetail.contract.GiftInfoDetailContract;
import com.example.carikado.main.giftinfo.model.GiftInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Merupakan class yang mengatur view dari gift info detail
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 11 Oktober 2017
 */
public class GiftInfoDetailFragment extends Fragment implements GiftInfoDetailContract.View {

    @BindView(R.id.tb_gift_info_detail)
    public Toolbar mTbGiftInfoDetail;

    @BindView(R.id.vp_gift_info_detail_image)
    public ViewPager mVpGiftInfoDetailImage;

    @BindView(R.id.tv_gift_info_detail_name)
    public TextView mTvGiftInfoDetailName;

    @BindView(R.id.tv_gift_info_detail_description)
    public TextView mTvGiftInfoDetailDescription;

    @BindView(R.id.tv_gift_info_detail_essence)
    public TextView mTvGiftInfoDetailEssence;

    @BindView(R.id.tv_gift_info_detail_age_from)
    public TextView mTvGiftInfoDetailAgeFrom;

    @BindView(R.id.tv_gift_info_detail_age_to)
    public TextView mTvGiftInfoDetailAgeTo;

    @BindView(R.id.tv_gift_info_detail_budget_from)
    public TextView mTvGiftInfoDetailBudgetFrom;

    @BindView(R.id.tv_gift_info_detail_budget_to)
    public TextView mTvGiftInfoDetailBudgetTo;

    @BindView(R.id.rv_gift_info_detail_category)
    public RecyclerView mRvGiftInfoDetailCategory;

    private GiftInfo mGiftInfo;
    private GiftInfoDetailCategoryAdapter mAdapter;
    private GiftInfoDetailContract.Presenter mPresenter;

    public GiftInfoDetailFragment() {
        super();
    }

    public static GiftInfoDetailFragment newInstance(GiftInfo giftInfo) {
        GiftInfoDetailFragment giftInfoDetailFragment = new GiftInfoDetailFragment();
        Bundle bundle = new Bundle();

        bundle.putSerializable("Gift Info", giftInfo);
        giftInfoDetailFragment.setArguments(bundle);

        return giftInfoDetailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gift_info_detail_fragment, container, false);
        ButterKnife.bind(this, view);

        mTbGiftInfoDetail.setTitle("");

        ((AppCompatActivity) getActivity()).setSupportActionBar(mTbGiftInfoDetail);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        if (getArguments() != null)
            mGiftInfo = (GiftInfo) getArguments().getSerializable("Gift Info");

        mRvGiftInfoDetailCategory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mRvGiftInfoDetailCategory.setHasFixedSize(true);
        mRvGiftInfoDetailCategory.setNestedScrollingEnabled(false);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart(mGiftInfo);
    }

    @Override
    public void setPresenter(@NonNull GiftInfoDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public Context getContextView() {
        return getContext();
    }

    @Override
    public void showDetail(@NonNull GiftInfo giftInfo) {
        mTvGiftInfoDetailName.setText(giftInfo.getTitle());
        mTvGiftInfoDetailDescription.setText(giftInfo.getDescription());
        mTvGiftInfoDetailEssence.setText(giftInfo.getEssence());
        mTvGiftInfoDetailAgeFrom.setText(String.valueOf(giftInfo.getGiftInfoAge().getFrom()));
        mTvGiftInfoDetailAgeTo.setText(String.valueOf(giftInfo.getGiftInfoAge().getTo()));
        mTvGiftInfoDetailBudgetFrom.setText(String.valueOf(giftInfo.getGiftInfoBudget().getFrom()));
        mTvGiftInfoDetailBudgetTo.setText(String.valueOf(giftInfo.getGiftInfoBudget().getTo()));
    }

    @Override
    public void showDetailImages(@NonNull List images) {
        // TODO tampilkan gambar-gambar gift info
    }

    @Override
    public void showDetailCategory(@NonNull List categories) {
        mAdapter = new GiftInfoDetailCategoryAdapter(getContext(), (ArrayList) categories);
        mRvGiftInfoDetailCategory.setAdapter(mAdapter);
    }
}
