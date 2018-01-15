package com.example.carikado.resultgift.presenter;

import android.support.annotation.NonNull;

import com.example.carikado.R;
import com.example.carikado.base.model.MyPage;
import com.example.carikado.main.findgift.model.Search;
import com.example.carikado.resultgift.contract.ResultGiftContract;
import com.example.carikado.resultgift.datasource.GiftDataSource;
import com.example.carikado.resultgift.datasource.GiftRepository;
import com.example.carikado.resultgift.model.Gift;

import java.util.Collections;
import java.util.List;

/**
 * Merupakan presenter yang mengatur logic dari result gift
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 11 Oktober 2017
 */
public class ResultGiftPresenter implements ResultGiftContract.Presenter {

    private GiftRepository mGiftRepository;
    private ResultGiftContract.View mView;

    private Integer page = 1;
    private Integer lastPage = 1;
    private Integer pageSize = 10;
    private Integer sort = 1;

    public ResultGiftPresenter(GiftRepository giftRepository, ResultGiftContract.View view) {
        mGiftRepository = giftRepository;
        mView = view;

        mView.setPresenter(this);
    }

    @Override
    public void onCreate() {
        // Do nothing
    }

    @Override
    public void onStart() {
        mView.showFirstGifts();
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

    private void loadGifts(@NonNull Search search, @NonNull final List<Gift> gifts) {
        mGiftRepository.loadGifts(page, pageSize, sort, search, new GiftDataSource.LoadGiftsCallback() {

            @Override
            public void onLoadSuccess(@NonNull MyPage<List<Gift>> giftPages) {
                if (mView.getContextView() != null) {
                    List<Gift> giftList = giftPages.getData();
                    Collections.addAll(gifts, giftList.toArray(new Gift[0]));

                    lastPage = giftPages.getLastPage();
                    mView.notifyGifts();
                }
            }

            @Override
            public void onLoadFailed(@NonNull String message) {
                if (mView.getContextView() != null)
                    mView.showToastMessage(message);
            }
        });
    }

    @Override
    public void loadFirstGifts(@NonNull Search search, @NonNull List<Gift> gifts) {
        page = 1;
        gifts.clear();
        loadGifts(search, gifts);
    }

    @Override
    public void loadNextGifts(@NonNull Search search, @NonNull List<Gift> gifts) {
        if (!page.equals(lastPage)) {
            page++;
            loadGifts(search, gifts);
        } else {
            String message = mView.getContextView().getString(R.string.last_page_error);
            mView.showToastMessage(message);
        }
    }

    @Override
    public void showResultGifts() {
        mView.showResultGifts();
    }

    @Override
    public void hideResultGifts() {
        mView.hideResultGifts();
    }

    @Override
    public void openSortByDialog() {
        mView.showSortByDialog();
    }

    @Override
    public void changeSortBy(@NonNull Integer sort) {
        this.sort = sort;
        mView.showFirstGifts();
    }

    @Override
    public void openGiftDetail(@NonNull Gift gift) {
        mView.showGiftDetail(gift);
    }
}
