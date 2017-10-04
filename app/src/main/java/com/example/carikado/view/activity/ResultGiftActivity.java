package com.example.carikado.view.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.carikado.R;
import com.example.carikado.adapter.ResultGiftAdapter;

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
        setContentView(R.layout.activity_result_gift);

        Toolbar tbResultGift = (Toolbar) findViewById(R.id.tb_result_gift);
        tbResultGift.setTitle("");

        setSupportActionBar(tbResultGift);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        RecyclerView rvResultGift = (RecyclerView) findViewById(R.id.rv_result_gift);
        rvResultGift.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvResultGift.setHasFixedSize(true);
        rvResultGift.setNestedScrollingEnabled(false);

        ArrayList<String> resultGiftDummyList = new ArrayList<>();

        resultGiftDummyList.add("Teddy Bear");
        resultGiftDummyList.add("Kaca Mata");
        resultGiftDummyList.add("Bunga Mawar");
        resultGiftDummyList.add("Bunga Melati");
        resultGiftDummyList.add("Teddy Bear Bear Teddy Bear");
        resultGiftDummyList.add("Kaca Mata");
        resultGiftDummyList.add("Bunga Mawar");
        resultGiftDummyList.add("Bunga Melati");

        ResultGiftAdapter resultGiftAdapter = new ResultGiftAdapter(this, resultGiftDummyList);
        rvResultGift.setAdapter(resultGiftAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return false;
        }
    }
}
