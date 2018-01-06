package com.example.carikado.resultgift.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carikado.R;
import com.example.carikado.main.findgift.model.Search;
import com.example.carikado.resultgift.adapter.ResultGiftAdapter;
import com.example.carikado.resultgift.contract.ResultGiftContract;
import com.example.carikado.resultgift.model.Gift;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Merupakan class yang mengatur view dari result gift
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 11 Oktober 2017
 */
public class ResultGiftFragment extends Fragment implements ResultGiftContract.View {

    @BindView(R.id.nsv_result_gift)
    public NestedScrollView mNsvResultGift;

    @BindView(R.id.tb_result_gift)
    public Toolbar mTbResultGift;

    @BindView(R.id.tiet_search)
    public TextInputEditText mTietSearch;

    @BindView(R.id.tv_result_gift)
    public TextView mTvResultGift;

    @BindView(R.id.rv_result_gift)
    public RecyclerView mRvResultGift;

    @BindView(R.id.srl_result_gift)
    public SwipeRefreshLayout mSrlResultGift;

    private ArrayList<Gift> mGifts;
    private ResultGiftAdapter mAdapter;
    private ResultGiftContract.Presenter mResultGiftPresenter;
    private Search mSearch;

    public ResultGiftFragment() {
        // Default construrctor
    }

    public static ResultGiftFragment newInstance(Search search) {
        ResultGiftFragment resultGiftFragment = new ResultGiftFragment();
        Bundle bundle = new Bundle();

        bundle.putSerializable("search", search);
        resultGiftFragment.setArguments(bundle);

        return resultGiftFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_gift_fragment, container, false);
        ButterKnife.bind(this, view);

        mTbResultGift.setTitle("");
        ((AppCompatActivity) getActivity()).setSupportActionBar(mTbResultGift);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        if (getArguments() != null)
            mSearch = (Search) getArguments().getSerializable("search");

        mNsvResultGift.setOnScrollChangeListener(new OnScrollListener());

        mRvResultGift.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRvResultGift.setHasFixedSize(true);
        mRvResultGift.setNestedScrollingEnabled(false);

        mSrlResultGift.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);
        mSrlResultGift.setOnRefreshListener(new OnRefreshListener());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mResultGiftPresenter.onStart();
    }

    @Override
    public void setPresenter(@NonNull ResultGiftContract.Presenter presenter) {
        mResultGiftPresenter = presenter;
    }

    @Override
    public Context getContextView() {
        return getContext();
    }

    @Override
    public void showFirstGifts() {
        if (mGifts == null)
            mGifts = new ArrayList<>();

        mSrlResultGift.post(new Runnable() {

            @Override
            public void run() {
                mSrlResultGift.setRefreshing(true);
                mResultGiftPresenter.loadFirstGifts(mSearch, mGifts);
            }
        });
    }

    @Override
    public void notifyGifts() {
        mSrlResultGift.setRefreshing(false);

        if (mGifts.size() != 0)
            mResultGiftPresenter.showResultGifts();
        else
            mResultGiftPresenter.hideResultGifts();

        if (mAdapter == null) {
            mAdapter = new ResultGiftAdapter(getContext(), mGifts, mResultGiftPresenter);
            mRvResultGift.setAdapter(mAdapter);
        } else
            mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToastMessage(@NonNull String message) {
        mSrlResultGift.setRefreshing(false);
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showResultGifts() {
        mRvResultGift.setVisibility(View.VISIBLE);
        mTvResultGift.setVisibility(View.GONE);
    }

    @Override
    public void hideResultGifts() {
        mRvResultGift.setVisibility(View.GONE);
        mTvResultGift.setVisibility(View.VISIBLE);
    }

    @Override
    public void showGiftDetail(@NonNull Gift gift) {
        String url = gift.getLink();

        if (!url.startsWith("http://") && !url.startsWith("https://"))
            url = "http://" + url;

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private class OnScrollListener implements NestedScrollView.OnScrollChangeListener {

        @Override
        public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            int height = v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight();

            if (scrollY == height)
                mResultGiftPresenter.loadNextGifts(mSearch, mGifts);
        }
    }

    private class OnRefreshListener implements SwipeRefreshLayout.OnRefreshListener {

        @Override
        public void onRefresh() {
            mResultGiftPresenter.loadFirstGifts(mSearch, mGifts);
        }
    }
}
