package com.example.carikado.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.carikado.adapter.GiftInfoAdapter;
import com.example.carikado.R;
import com.example.carikado.view.activity.ReviewActivity;

import java.util.ArrayList;

/**
 * Merupakan tampilan untuk mencari informasi tentang kado-kado
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 25 September 2017
 */

public class GiftInfoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gift_info, container, false);

        Toolbar tbGiftInfo = (Toolbar) view.findViewById(R.id.tb_gift_info);
        tbGiftInfo.setTitle("");

        ((AppCompatActivity) getActivity()).setSupportActionBar(tbGiftInfo);

        RecyclerView rvGiftInfo = (RecyclerView) view.findViewById(R.id.rv_gift_info);
        rvGiftInfo.setLayoutManager(new LinearLayoutManager(getContext()));
        rvGiftInfo.setHasFixedSize(true);
        rvGiftInfo.setNestedScrollingEnabled(false);

        ArrayList<String> giftInfoDummyList = new ArrayList<>();

        giftInfoDummyList.add("Teddy Bear");
        giftInfoDummyList.add("Kaca Mata");
        giftInfoDummyList.add("Bunga Mawar");
        giftInfoDummyList.add("Bunga Melati");
        giftInfoDummyList.add("Teddy Bear");
        giftInfoDummyList.add("Kaca Mata");
        giftInfoDummyList.add("Bunga Mawar");
        giftInfoDummyList.add("Bunga Melati");

        GiftInfoAdapter giftInfoAdapter = new GiftInfoAdapter(getContext(), giftInfoDummyList);
        rvGiftInfo.setAdapter(giftInfoAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.gift_info_menu, menu);
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
}
