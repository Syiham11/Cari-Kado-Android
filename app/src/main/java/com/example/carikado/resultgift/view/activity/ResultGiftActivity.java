package com.example.carikado.resultgift.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.carikado.R;
import com.example.carikado.main.findgift.model.Search;
import com.example.carikado.resultgift.presenter.ResultGiftPresenter;
import com.example.carikado.resultgift.view.fragment.ResultGiftFragment;
import com.example.carikado.util.ActivityUtils;
import com.example.carikado.util.Injection;

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

        Search search = (Search) getIntent().getSerializableExtra("search");

        ResultGiftFragment resultGiftFragment = ResultGiftFragment.newInstance(search);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), resultGiftFragment,
                R.id.fl_result_gift);

        new ResultGiftPresenter(Injection.provideGiftRepository(this), resultGiftFragment);
    }
}
