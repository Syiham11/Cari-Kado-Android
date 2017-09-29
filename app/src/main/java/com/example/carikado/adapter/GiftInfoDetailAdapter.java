package com.example.carikado.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.carikado.R;
import com.example.carikado.view.activity.GiftInfoDetailActivity;
import com.example.carikado.viewholder.GIftInfoViewHolder;
import com.example.carikado.viewholder.GiftInfoDetailCategoryViewHolder;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Merupakan class adapter untuk menggenerate list kategori informasi kado
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 28 September 2017
 */

public class GiftInfoDetailAdapter extends RecyclerView.Adapter<GiftInfoDetailCategoryViewHolder> {

    private ArrayList giftInfoList;
    private Context context;
    private LayoutInflater inflater;

    public GiftInfoDetailAdapter(Context context, ArrayList giftInfoList) {
        this.context = context;
        this.giftInfoList = giftInfoList;

        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public GiftInfoDetailCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_gift_info_detail_category, parent, false);
        return new GiftInfoDetailCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GiftInfoDetailCategoryViewHolder holder, int position) {
        holder.getTvGiftInfoDetailCategory().setText((String) giftInfoList.get(position));
    }

    @Override
    public int getItemCount() {
        return giftInfoList.size();
    }
}
