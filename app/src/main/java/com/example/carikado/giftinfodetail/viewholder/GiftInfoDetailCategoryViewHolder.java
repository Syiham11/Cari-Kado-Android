package com.example.carikado.giftinfodetail.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.carikado.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Merupakan viewholder untuk item dari item gift info detail category
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 12 Oktober 2017
 */
public class GiftInfoDetailCategoryViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.cv_gift_info_detail_category)
    public CardView cvGiftInfoDetailCategory;

    @BindView(R.id.tv_gift_info_detail_category)
    public TextView tvGiftInfoDetailCategory;

    public GiftInfoDetailCategoryViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
