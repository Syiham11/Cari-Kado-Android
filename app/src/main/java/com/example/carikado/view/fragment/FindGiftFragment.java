package com.example.carikado.view.fragment;

import android.content.Intent;
import android.os.Bundle;
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
import android.widget.EditText;
import android.widget.Spinner;

import com.example.carikado.R;
import com.example.carikado.view.activity.ResultGiftActivity;
import com.example.carikado.view.activity.ReviewActivity;

/**
 * Merupakan tampilan untuk mencari kado
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 25 September 2017
 */

public class FindGiftFragment extends Fragment {

    private TextInputEditText tietAge, tietBudgetFrom, tietBudgetTo;
    private TextInputLayout tilAge, tilBudgetFrom, tilBudgetTo;
    private Spinner spGender, spCategory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_gift, container, false);

        Toolbar tbFindGift = (Toolbar) view.findViewById(R.id.tb_find_gift);
        tbFindGift.setTitle("");

        ((AppCompatActivity) getActivity()).setSupportActionBar(tbFindGift);

        tietAge = (TextInputEditText) view.findViewById(R.id.tiet_age);
        tietBudgetFrom = (TextInputEditText) view.findViewById(R.id.tiet_budget_from);
        tietBudgetTo = (TextInputEditText) view.findViewById(R.id.tiet_budget_to);

        spGender = (Spinner) view.findViewById(R.id.sp_gender);
        spCategory = (Spinner) view.findViewById(R.id.sp_category);

        view.findViewById(R.id.btn_search).setOnClickListener(new SearchClickedListener());

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
                startActivity(new Intent(getContext(), ReviewActivity.class));
                return true;
            default:
                return false;
        }
    }

    private class SearchClickedListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            getActivity().startActivity(new Intent(getContext(), ResultGiftActivity.class));
        }
    }
}
