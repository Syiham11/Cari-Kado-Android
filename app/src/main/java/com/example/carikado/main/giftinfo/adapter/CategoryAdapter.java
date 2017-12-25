package com.example.carikado.main.giftinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import com.example.carikado.main.giftinfo.contract.GiftInfoContract;
import com.example.carikado.main.giftinfo.model.GiftInfoCategory;

import java.util.ArrayList;

/**
 * Created by Faza Zulfika P P on 12/20/2017.
 */

public class CategoryAdapter extends ArrayAdapter<String> {

    private ArrayList<GiftInfoCategory> mGiftInfoCategories;
    private Context mContext;
    private GiftInfoContract.Presenter mPresenter;
    private LayoutInflater mInflater;

    public CategoryAdapter(Context context, ArrayList<GiftInfoCategory> giftInfoCategories, GiftInfoContract.Presenter presenter) {
        super(context);
    }
}
