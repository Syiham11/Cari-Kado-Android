package com.example.carikado.resultgift.view.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.carikado.R;
import com.example.carikado.resultgift.adapter.ResultGiftAdapter;
import com.example.carikado.resultgift.presenter.ResultGiftPresenter;
import com.example.carikado.resultgift.view.fragment.ResultGiftFragment;
import com.example.carikado.util.ActivityUtils;

import java.util.ArrayList;

/**
 * Activity yang digunakna untuk mengatur tampilan hasil pencarian kado
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 28 September 2017
 */
public class ResultGiftActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_gift_activity);

        ResultGiftFragment resultGiftFragment = ResultGiftFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), resultGiftFragment,
                R.id.fl_result_gift);

        new ResultGiftPresenter(resultGiftFragment);
    }
}
