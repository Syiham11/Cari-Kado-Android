package com.example.carikado.main.giftinfo.presenter;

import android.support.annotation.NonNull;

import com.example.carikado.R;
import com.example.carikado.base.model.MyPage;
import com.example.carikado.main.giftinfo.contract.GiftInfoContract;
import com.example.carikado.main.giftinfo.datasource.GiftInfoDataSource;
import com.example.carikado.main.giftinfo.datasource.GiftInfoRepository;
import com.example.carikado.main.giftinfo.model.GiftInfo;

import java.util.List;

/**
 * Merupakan presenter untuk mencari info kado
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 9 Oktober 2017
 */
public class GiftInfoPresenter implements GiftInfoContract.Presenter {

    private final GiftInfoContract.View mView;
    private GiftInfoRepository mGiftInfoRepository;

    private Integer page = 1;
    private Integer lastPage = 1;
    private Integer pageSize = 10;
    private Integer sort = 1;

    public GiftInfoPresenter(GiftInfoRepository giftInfoRepository, @NonNull GiftInfoContract.View view) {
        mGiftInfoRepository = giftInfoRepository;
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void onCreate() {
        // Do nothing
    }

    @Override
    public void onStart() {
        // Do nothing
    }

    @Override
    public void onResume() {
        mView.showFirstGiftInfos();
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

    private void loadGiftInfos(@NonNull final List giftInfoList) {
        mGiftInfoRepository.loadGiftInfos(page, pageSize, sort, new GiftInfoDataSource.LoadGiftInfosCallback() {

            @Override
            public void onLoadSuccess(@NonNull MyPage<List<GiftInfo>> giftInfoPages) {
                List<GiftInfo> giftInfos = giftInfoPages.getData();

                for (GiftInfo giftInfo : giftInfos)
                    giftInfoList.add(giftInfo);

                lastPage = giftInfoPages.getLastPage();
                mView.notifyGiftInfos();
            }

            @Override
            public void onLoadFailed(@NonNull String message) {
                mView.showToastMessage(message);
            }
        });
    }

    @Override
    public void loadFirstGiftInfos(@NonNull List giftInfoList) {
        page = 1;
        giftInfoList.clear();
        loadGiftInfos(giftInfoList);
    }

    @Override
    public void loadNextGiftInfos(@NonNull List giftInfoList) {
        if (!page.equals(lastPage)) {
            page++;
            loadGiftInfos(giftInfoList);
        } else {
            String message = mView.getContextView().getString(R.string.last_page_error);
            mView.showToastMessage(message);
        }
    }

    @Override
    public void openReview() {
        mView.showReview();
    }

    @Override
    public void openGiftInfoDetail(@NonNull GiftInfo giftInfo) {
        mView.showGiftInfoDetail(giftInfo);
    }
}
