package com.example.carikado.resultgift.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carikado.R;
import com.example.carikado.resultgift.adapter.ResultGiftAdapter;
import com.example.carikado.resultgift.contract.ResultGiftContract;

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

    @BindView(R.id.tb_result_gift)
    public Toolbar mTbResultGift;

    @BindView(R.id.tiet_search)
    public TextInputEditText mTietSearch;

    @BindView(R.id.til_search)
    public TextInputLayout mTilSearch;

    @BindView(R.id.rv_result_gift)
    public RecyclerView mRvResultGift;

    private ArrayList<String> mGifts;
    private ResultGiftAdapter mAdapter;
    private ResultGiftContract.Presenter mResultGiftPresenter;

    public ResultGiftFragment() {
        // Default construrctor
    }

    public static ResultGiftFragment newInstance() {
        return new ResultGiftFragment();
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

        mRvResultGift.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRvResultGift.setHasFixedSize(true);
        mRvResultGift.setNestedScrollingEnabled(false);

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
    public void showGifts() {
        if (mGifts == null)
            mGifts = new ArrayList<>();

        mGifts.add("Teddy Bear");
        mGifts.add("Kaca Mata");
        mGifts.add("Bunga Mawar");
        mGifts.add("Bunga Melati");
        mGifts.add("Teddy Bear Bear Teddy Bear");
        mGifts.add("Kaca Mata");
        mGifts.add("Bunga Mawar");
        mGifts.add("Bunga Melati");

        mResultGiftPresenter.loadGifts(mGifts);

        if (mAdapter == null) {
            mAdapter = new ResultGiftAdapter(getContext(), mGifts);
            mRvResultGift.setAdapter(mAdapter);
        }
    }

    @Override
    public void showGiftDetail() {
        // TODO masukkan parameter model
        // TODO pindah ke detail kado
    }
}
