package com.example.carikado.view.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.carikado.R;
import com.example.carikado.adapter.GiftInfoDetailAdapter;

import java.util.ArrayList;

/**
 * Activity yang digunakna untuk mengatur tampilan detail informasi kado
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 29 September 2017
 */

public class GiftInfoDetailActivity extends AppCompatActivity {

    private ArrayList<String> giftInfoDummyList = new ArrayList<>();
    private RecyclerView rvGiftInfoDetailCategory;
    private TextView tvGiftInfoDetailName, tvGiftInfoDetailDescription, tvGiftInfoDetailEssence, tvGiftInfoDetailAgeFrom, tvGiftInfoDetailAgeTo, tvGiftInfoDetailBudgetFrom, tvGiftInfoDetailBudgetTo;
    private ViewPager vpGiftInfoDetailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift_info_detail);

        Toolbar tbGiftInfoDetail = (Toolbar) findViewById(R.id.tb_gift_info_detail);
        tbGiftInfoDetail.setTitle("");

        setSupportActionBar(tbGiftInfoDetail);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        String name = (String) getIntent().getSerializableExtra("Gift Info");

        tvGiftInfoDetailName = (TextView) findViewById(R.id.tv_gift_info_detail_name);
        tvGiftInfoDetailName.setText(name);

        rvGiftInfoDetailCategory = (RecyclerView) findViewById(R.id.rv_gift_info_detail_category);
        rvGiftInfoDetailCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvGiftInfoDetailCategory.setHasFixedSize(true);
        rvGiftInfoDetailCategory.setNestedScrollingEnabled(false);

        setGiftInfoDetailCategoryData();

        GiftInfoDetailAdapter giftInfoDetailAdapter = new GiftInfoDetailAdapter(this, giftInfoDummyList);
        rvGiftInfoDetailCategory.setAdapter(giftInfoDetailAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setGiftInfoDetailCategoryData() {
        giftInfoDummyList.add("Teddy Bear");
        giftInfoDummyList.add("Kaca Mata");
        giftInfoDummyList.add("Bunga Mawar");
        giftInfoDummyList.add("Bunga Melati");
        giftInfoDummyList.add("Teddy Bear");
        giftInfoDummyList.add("Kaca Mata");
        giftInfoDummyList.add("Bunga Mawar");
        giftInfoDummyList.add("Bunga Melati");
    }
}
