package com.example.carikado.main.giftinfo.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.carikado.giftinfodetail.view.activity.GiftInfoDetailActivity;
import com.example.carikado.main.giftinfo.adapter.GiftInfoAdapter;
import com.example.carikado.R;
import com.example.carikado.main.giftinfo.contract.GiftInfoContract;
import com.example.carikado.main.giftinfo.model.GiftInfo;

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

    @BindView(R.id.nsv_gift_info)
    public NestedScrollView mNsvGiftInfo;

    @BindView(R.id.rv_gift_info)
    public RecyclerView mRvGiftInfo;

    @BindView(R.id.srl_gift_info)
    public SwipeRefreshLayout mSrlGiftInfo;

    @BindView(R.id.tb_gift_info)
    public Toolbar mTbGiftInfo;

    private AlertDialog mSortByDialog;
    private ArrayList<GiftInfo> mGiftInfos;
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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gift_info_fragment, container, false);
        ButterKnife.bind(this, view);

        mTbGiftInfo.setTitle("");

        if (getActivity() != null)
            ((AppCompatActivity) getActivity()).setSupportActionBar(mTbGiftInfo);

        mNsvGiftInfo.setOnScrollChangeListener(new OnScrollListener());

        mRvGiftInfo.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvGiftInfo.setHasFixedSize(true);
        mRvGiftInfo.setNestedScrollingEnabled(false);

        mSrlGiftInfo.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);
        mSrlGiftInfo.setOnRefreshListener(new OnRefreshListener());

        setUpSortByDialog();

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
            case R.id.menu_sort_by:
                mGiftInfoPresenter.openSortByDialog();
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
    public Context getContextView() {
        return getContext();
    }

    @Override
    public void showFirstGiftInfos() {
        if (mGiftInfos == null)
            mGiftInfos = new ArrayList<>();

        mSrlGiftInfo.post(new Runnable() {

            @Override
            public void run() {
                mSrlGiftInfo.setRefreshing(true);
                mGiftInfoPresenter.loadFirstGiftInfos(mGiftInfos);
            }
        });
    }

    @Override
    public void notifyGiftInfos() {
        mSrlGiftInfo.setRefreshing(false);

        if (mGiftInfoAdapter == null) {
            mGiftInfoAdapter = new GiftInfoAdapter(getContext(), mGiftInfos, mGiftInfoPresenter);
            mRvGiftInfo.setAdapter(mGiftInfoAdapter);
        } else
            mGiftInfoAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToastMessage(@NonNull String message) {
        mSrlGiftInfo.setRefreshing(false);
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSortByDialog() {
        mSortByDialog.show();
    }

    @Override
    public void showGiftInfoDetail(@NonNull GiftInfo giftInfo) {
        Intent intent = new Intent(getContext(), GiftInfoDetailActivity.class);
        intent.putExtra("Gift Info", giftInfo);

        startActivity(intent);
    }

    private void setUpSortByDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        String title = getString(R.string.sort_by);
        String[] sorts = getResources().getStringArray(R.array.gift_info_sort_by);
        int[] sortCodes = getResources().getIntArray(R.array.gift_info_sort_by_code);

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.sort_by_dialog, null);

        RadioGroup rgSortBy = view.findViewById(R.id.rg_sort_by);

        for (int i = 0; i < sorts.length; i++) {
            RadioButton radioButton = new RadioButton(getContext());
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            if (i == 0)
                radioButton.setChecked(true);

            radioButton.setId(sortCodes[i]);
            radioButton.setLayoutParams(params);
            radioButton.setText(sorts[i]);

            rgSortBy.addView(radioButton);
        }

        rgSortBy.setOnCheckedChangeListener(new OnCheckedChangedListener());

        builder.setTitle(title)
                .setView(view);

        mSortByDialog = builder.create();
    }

    private class OnCheckedChangedListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            mGiftInfoPresenter.changeSortBy(checkedId);
            mSortByDialog.dismiss();
        }
    }

    private class OnScrollListener implements NestedScrollView.OnScrollChangeListener {

        @Override
        public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            int height = v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight();

            if (scrollY == height)
                mGiftInfoPresenter.loadNextGiftInfos(mGiftInfos);
        }
    }

    private class OnRefreshListener implements SwipeRefreshLayout.OnRefreshListener {

        @Override
        public void onRefresh() {
            mGiftInfoPresenter.loadFirstGiftInfos(mGiftInfos);
        }
    }
}
