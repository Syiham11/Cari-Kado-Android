package com.example.carikado.main.findgift.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.carikado.R;
import com.example.carikado.main.findgift.contract.FindGiftContract;
import com.example.carikado.main.findgift.model.Search;
import com.example.carikado.resultgift.view.activity.ResultGiftActivity;
import com.example.carikado.review.view.activity.ReviewActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Merupakan tampilan untuk mencari kado
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 25 September 2017
 */
public class FindGiftFragment extends Fragment implements FindGiftContract.View {

    @BindView(R.id.tiet_age)
    public TextInputEditText mTietAge;

    @BindView(R.id.tiet_budget_from)
    public TextInputEditText mTietBudgetFrom;

    @BindView(R.id.tiet_budget_to)
    public TextInputEditText mTietBudgetTo;

    @BindView(R.id.til_age)
    public TextInputLayout mTilAge;

    @BindView(R.id.til_budget_from)
    public TextInputLayout mTilBudgetFrom;

    @BindView(R.id.til_budget_to)
    public TextInputLayout mTilBudgetTo;

    @BindView(R.id.tb_find_gift)
    public Toolbar mTbFindGift;

    @BindView(R.id.sp_gender)
    public Spinner mSpGender;

    @BindView(R.id.sp_category)
    public Spinner mSpCategory;

    @OnClick(R.id.btn_search)
    public void search() {
        String ageString = mTietAge.getText().toString();
        String budgetFromString = mTietBudgetFrom.getText().toString();
        String budgetToString = mTietBudgetTo.getText().toString();

        Integer age = ageString.equals("") ? 0 : Integer.valueOf(ageString);
        String gender = (String) mSpGender.getSelectedItem();
        Integer budgetFrom = budgetFromString.equals("") ? 0 : Integer.valueOf(budgetFromString);
        Integer budgetTo = budgetToString.equals("") ? 0 : Integer.valueOf(budgetToString);
        String category = (String) mSpCategory.getSelectedItem();

        Search search = new Search(age, gender, budgetFrom, budgetTo, category);
        mFindGiftPresenter.findGift(search);
    }

    private ArrayAdapter<String> mGenderAdapter, mCategoryAdapter;
    private ArrayList<String> mGenders, mGiftInfoCategories;
    private FindGiftContract.Presenter mFindGiftPresenter;

    public FindGiftFragment() {
        // Default constructor
    }

    public static FindGiftFragment newInstance() {
        return new FindGiftFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_gift_fragment, container, false);
        ButterKnife.bind(this, view);

        mTbFindGift.setTitle("");
        ((AppCompatActivity) getActivity()).setSupportActionBar(mTbFindGift);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.find_gift_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.menu_review:
                mFindGiftPresenter.openReview();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mFindGiftPresenter.onStart();
    }

    @Override
    public void setPresenter(@NonNull FindGiftContract.Presenter presenter) {
        mFindGiftPresenter = presenter;
    }

    @Override
    public Context getContextView() {
        return getContext();
    }

    @Override
    public void showGender() {
        if (mGenders == null)
            mGenders = new ArrayList<>();

        mFindGiftPresenter.loadGender(mGenders);
    }

    @Override
    public void notifyGender() {
        if (mGenderAdapter == null) {
            mGenderAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, mGenders);
            mGenderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            mSpGender.setAdapter(mGenderAdapter);
        } else
            mGenderAdapter.notifyDataSetChanged();
    }

    @Override
    public void showCategory() {
        if (mGiftInfoCategories == null)
            mGiftInfoCategories = new ArrayList<>();

        mFindGiftPresenter.loadCategory(mGiftInfoCategories);
    }

    @Override
    public void notifyCategory() {
        if (mCategoryAdapter == null) {
            mCategoryAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, mGiftInfoCategories);
            mCategoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            mSpCategory.setAdapter(mCategoryAdapter);
        } else
            mCategoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToastMessage(@NonNull String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showAgeEmpty() {
        mTilAge.setErrorEnabled(true);
        mTietAge.setError(getString(R.string.age_empty));
    }

    @Override
    public void hideAgeEmpty() {
        mTilAge.setErrorEnabled(false);
    }

    @Override
    public void showBudgetFromEmpty() {
        mTilBudgetFrom.setErrorEnabled(true);
        mTilBudgetFrom.setError(getString(R.string.budget_empty));
    }

    @Override
    public void hideBudgetFromEmpty() {
        mTilBudgetFrom.setErrorEnabled(false);
    }

    @Override
    public void showBudgetToEmpty() {
        mTilBudgetTo.setErrorEnabled(true);
        mTilBudgetTo.setError(getString(R.string.budget_empty));
    }

    @Override
    public void hideBudgetToEmpty() {
        mTilBudgetTo.setErrorEnabled(false);
    }

    @Override
    public void showResultGift(@NonNull Search search) {
        Intent intent = new Intent(getContext(), ResultGiftActivity.class);
        Bundle bundle = new Bundle();

        bundle.putSerializable("search", search);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void showReview() {
        Intent intent = new Intent(getContext(), ReviewActivity.class);
        startActivity(intent);
    }
}
