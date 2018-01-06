package com.example.carikado.main.findgift.presenter;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.carikado.main.findgift.contract.FindGiftContract;
import com.example.carikado.main.findgift.datasource.GenderDataSource;
import com.example.carikado.main.findgift.datasource.GenderRepository;
import com.example.carikado.main.findgift.datasource.GiftInfoCategoryDataSource;
import com.example.carikado.main.findgift.datasource.GiftInfoCategoryRepository;
import com.example.carikado.main.findgift.model.Search;
import com.example.carikado.main.giftinfo.model.GiftInfoCategory;

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
    private final GenderRepository mGenderRepository;
    private final GiftInfoCategoryRepository mGiftInfoCategoryRepository;

    public FindGiftPresenter(@NonNull GiftInfoCategoryRepository giftInfoCategoryRepository,
                             @NonNull GenderRepository genderRepository,
                             @NonNull FindGiftContract.View view) {
        mGiftInfoCategoryRepository = giftInfoCategoryRepository;
        mGenderRepository = genderRepository;
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
    public void loadGender(@NonNull final List genderList) {
        mGenderRepository.loadGenders(new GenderDataSource.LoadGendersCallback() {

            @Override
            public void onLoadSuccess(@NonNull List genders) {
                for (Object o : genders)
                    genderList.add(o);

                mView.notifyGender();
            }

            @Override
            public void onLoadFailed(@NonNull String message) {
                mView.showToastMessage(message);
            }
        });
    }

    @Override
    public void loadCategory(@NonNull final List categoryList) {
        mGiftInfoCategoryRepository.loadGiftInfoCategories(new GiftInfoCategoryDataSource.LoadGiftInfoCategoriessCallback() {

            @Override
            public void onLoadSuccess(@NonNull List giftInfoCategories) {
                for (Object o : giftInfoCategories) {
                    GiftInfoCategory giftInfoCategory = (GiftInfoCategory) o;
                    categoryList.add(giftInfoCategory.getName());
                }

                mView.notifyCategory();
            }

            @Override
            public void onLoadFailed(@NonNull String message) {
                mView.showToastMessage(message);
            }
        });
    }

    @Override
    public void findGift(@NonNull Search search) {
        boolean isValidated = true;

        if (search.getAge() == 0) {
            mView.showAgeEmpty();
            isValidated = false;
        } else
            mView.hideAgeEmpty();

        if (search.getBudgetFrom() == 0) {
            mView.showBudgetFromEmpty();
            isValidated = false;
        } else
            mView.hideBudgetFromEmpty();

        if (search.getBudgetTo() == 0) {
            mView.showBudgetToEmpty();
            isValidated = false;
        } else
            mView.hideBudgetToEmpty();

        if (isValidated) {
            mView.showResultGift(search);
        }
    }

    @Override
    public void openReview() {
        mView.showReview();
    }
}
