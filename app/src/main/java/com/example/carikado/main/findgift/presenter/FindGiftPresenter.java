package com.example.carikado.main.findgift.presenter;

import android.support.annotation.NonNull;

import com.example.carikado.main.findgift.contract.FindGiftContract;
import com.example.carikado.main.findgift.datasource.GenderDataSource;
import com.example.carikado.main.findgift.datasource.GenderRepository;
import com.example.carikado.main.findgift.datasource.GiftInfoCategoryDataSource;
import com.example.carikado.main.findgift.datasource.GiftInfoCategoryRepository;
import com.example.carikado.main.findgift.model.Search;
import com.example.carikado.main.giftinfo.model.GiftInfoCategory;

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
        mView.showProgressDialog();

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
    public void loadGender(@NonNull final List<String> genderList) {
        mGenderRepository.loadGenders(new GenderDataSource.LoadGendersCallback() {

            @Override
            public void onLoadSuccess(@NonNull List<String> genders) {
                Collections.addAll(genderList, genders.toArray(new String[0]));
                mView.notifyGender();
            }

            @Override
            public void onLoadFailed(@NonNull String message) {
                mView.showToastMessage(message);
            }
        });
    }

    @Override
    public void loadCategory(@NonNull final List<String> categoryList) {
        mGiftInfoCategoryRepository.loadGiftInfoCategories(new GiftInfoCategoryDataSource.LoadGiftInfoCategoriessCallback() {

            @Override
            public void onLoadSuccess(@NonNull List<GiftInfoCategory> giftInfoCategories) {
                if (mView.getContextView() != null) {
                    for (GiftInfoCategory giftInfoCategory : giftInfoCategories)
                        categoryList.add(giftInfoCategory.getName());

                    mView.notifyCategory();
                    mView.hideProgressDialog();
                }
            }

            @Override
            public void onLoadFailed(@NonNull String message) {
                if (mView.getContextView() != null) {
                    mView.showToastMessage(message);
                    mView.hideProgressDialog();
                }
            }
        });
    }

    @Override
    public void findGift(@NonNull Search search) {
        boolean isValidated = !checkAgeIsEmpty(search.getAge()) &&
                !checkBudgetFromIsEmpty(search.getBudgetFrom()) &&
                !checkBudgetToIsEmpty(search.getBudgetTo());

        if (isValidated)
            mView.showResultGift(search);
    }

    private boolean checkAgeIsEmpty(int age) {
        boolean isEmpty = age == 0;

        if (isEmpty)
            mView.showAgeEmpty();
        else
            mView.hideAgeEmpty();

        return isEmpty;
    }

    private boolean checkBudgetFromIsEmpty(int budgetFrom) {
        boolean isEmpty = budgetFrom == 0;

        if (isEmpty)
            mView.showBudgetFromEmpty();
        else
            mView.hideBudgetFromEmpty();

        return isEmpty;
    }

    private boolean checkBudgetToIsEmpty(int budgetTo) {
        boolean isEmpty = budgetTo == 0;

        if (isEmpty)
            mView.showBudgetToEmpty();
        else
            mView.hideBudgetToEmpty();

        return isEmpty;
    }
}
