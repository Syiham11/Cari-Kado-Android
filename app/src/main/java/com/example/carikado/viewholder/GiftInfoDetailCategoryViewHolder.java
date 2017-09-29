package com.example.carikado.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.carikado.R;

/**
 * Created by Faza Zulfika P P on 9/29/2017.
 */

public class GiftInfoDetailCategoryViewHolder extends RecyclerView.ViewHolder {

    private CardView cvGiftInfoDetailCategory;
    private TextView tvGiftInfoDetailCategory;

    public GiftInfoDetailCategoryViewHolder(View itemView) {
        super(itemView);

        cvGiftInfoDetailCategory = (CardView) itemView.findViewById(R.id.cv_gift_info_detail_category);
        tvGiftInfoDetailCategory = (TextView) itemView.findViewById(R.id.tv_gift_info_detail_category);
    }

    public CardView getCvGiftInfoDetailCategory() {
        return cvGiftInfoDetailCategory;
    }

    public TextView getTvGiftInfoDetailCategory() {
        return tvGiftInfoDetailCategory;
    }
}
