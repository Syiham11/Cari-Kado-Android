package com.example.carikado.main.findgift.contract;

import android.support.annotation.NonNull;

import com.example.carikado.base.BasePresenter;
import com.example.carikado.base.BaseView;
import com.example.carikado.main.findgift.model.Search;

import java.util.List;

/**
 * Contract untuk mengatur view dan presenter pada findgift
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 8 Oktober 2017
 */
public interface FindGiftContract {

    interface View extends BaseView<Presenter> {

        void showGender();
        void notifyGender();
        void showCategory();
        void notifyCategory();
        void showToastMessage(@NonNull String message);
        void showAgeEmpty();
        void hideAgeEmpty();
        void showBudgetFromEmpty();
        void hideBudgetFromEmpty();
        void showBudgetToEmpty();
        void hideBudgetToEmpty();
        void showResultGift(@NonNull Search search);
        void showReview();
    }

    interface Presenter extends BasePresenter {

        void loadGender(@NonNull List genderList);
        void loadCategory(@NonNull List categoryList);
        void findGift(@NonNull Search search);
        void openReview();
    }
}
