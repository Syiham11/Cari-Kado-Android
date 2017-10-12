package com.example.carikado.giftinfodetail.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carikado.R;
import com.example.carikado.giftinfodetail.viewholder.GiftInfoDetailCategoryViewHolder;

import java.util.ArrayList;

/**
 * Merupakan class adapter untuk menggenerate list kategori informasi kado
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 28 September 2017
 */

public class GiftInfoDetailCategoryAdapter extends RecyclerView.Adapter<GiftInfoDetailCategoryViewHolder> {

    private ArrayList giftInfoList;
    private Context context;
    private LayoutInflater inflater;

    public GiftInfoDetailCategoryAdapter(Context context, ArrayList giftInfoList) {
        this.context = context;
        this.giftInfoList = giftInfoList;

        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public GiftInfoDetailCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.gift_info_detail_category_item, parent, false);
        return new GiftInfoDetailCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GiftInfoDetailCategoryViewHolder holder, int position) {
        holder.tvGiftInfoDetailCategory.setText((String) giftInfoList.get(position));
    }

    @Override
    public int getItemCount() {
        return giftInfoList.size();
    }
}
