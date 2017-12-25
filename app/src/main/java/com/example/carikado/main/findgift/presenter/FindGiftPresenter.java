package com.example.carikado.main.findgift.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.carikado.main.findgift.contract.FindGiftContract;
import com.example.carikado.main.findgift.datasource.GiftInfoCategoryDataSource;
import com.example.carikado.main.findgift.datasource.GiftInfoCategoryRepository;

import java.util.Collections;
import java.util.List;

/**
 * Merupakan presenter untuk mencari kado
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 8 Oktober 2017
 */
public class FindGiftPresenter implements FindGiftContract.Presenter {

    private final FindGiftContract.View mView;
    private final GiftInfoCategoryRepository mGiftInfoCategoryRepository;

    public FindGiftPresenter(@NonNull GiftInfoCategoryRepository giftInfoCategoryRepository,
                             @NonNull FindGiftContract.View view) {
        mGiftInfoCategoryRepository = giftInfoCategoryRepository;
        mView = view;
        view.setPresenter(this);
    }

    @Override
    public void onCreate() {
        // Do nothing
    }

    @Override
    public void onStart() {
        mView.showGender();
        mView.showCategory();
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
        // DO nothing
    }

    @Override
    public void loadGender(@NonNull List genderList) {
        // TODO load gender from database
    }

    @Override
    public void loadCategory(@NonNull final List categoryList) {
        mGiftInfoCategoryRepository.loadGiftInfoCategories(new GiftInfoCategoryDataSource.LoadGiftInfoCategoriessCallback() {

            @Override
            public void onLoadSuccess(@NonNull List giftInfoCategories) {
                for (Object o : giftInfoCategories)
                    categoryList.add(o);

                mView.notifyCategory();
            }

            @Override
            public void onLoadFailed(@NonNull String message) {
                mView.showToastMessage(message);
            }
        });
    }

    /*
     * TODO punya parameter model
     */
    @Override
    public void findGift() {
        boolean isValidated = true;

//        if (TextUtils.isEmpty(findGift.getAge())) {
//            mView.showAgeEmpty();
//            isValidated = false;
//        } else
//            mView.hideAgeEmpty();

//        if (TextUtils.isEmpty(findGift.getBudgetFrom())) {
//            mView.showBudgetFromEmpty();
//            isValidated = false;
//        } else
//            mView.hideBudgetFromEmpty();

//        if (TextUtils.isEmpty(findGift.getBudgetTo())) {
//            mView.showBudgetToEmpty();
//            isValidated = false;
//        } else
//            mView.hideBudgetToEmpty();

//        if (isValidated) {
            mView.showResultGift(); // TODO punya parameter model
            // TODO search gift from API
//        }
    }

    @Override
    public void openReview() {
        mView.showReview();
    }
}
