package com.example.carikado.giftinfodetail.view.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.carikado.R;
import com.example.carikado.giftinfodetail.adapter.GiftInfoDetailCategoryAdapter;
import com.example.carikado.giftinfodetail.presenter.GiftInfoDetailPresenter;
import com.example.carikado.giftinfodetail.view.fragment.GiftInfoDetailFragment;
import com.example.carikado.main.giftinfo.model.GiftInfo;
import com.example.carikado.util.ActivityUtils;

import java.util.ArrayList;

/**
 * Activity yang digunakna untuk mengatur tampilan detail informasi kado
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 29 September 2017
 */
public class GiftInfoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gift_info_detail_activity);

        GiftInfo giftInfo = (GiftInfo) getIntent().getSerializableExtra("Gift Info");

        GiftInfoDetailFragment giftInfoDetailFragment = GiftInfoDetailFragment.newInstance(giftInfo);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), giftInfoDetailFragment,
                R.id.fl_gift_info_detail);

        new GiftInfoDetailPresenter(giftInfoDetailFragment);
    }
}
