package com.example.carikado.view.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.carikado.R;

public class GiftInfoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift_info_detail);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            String s = (String) getIntent().getSerializableExtra("Gift Info");
            actionBar.setTitle(s);
        }
    }
}
