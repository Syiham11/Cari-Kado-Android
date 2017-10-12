package com.example.carikado.resultgift.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.carikado.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Merupakan viewholder untuk item dari item result gift
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 12 Oktober 2017
 */
public class ResultGiftViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.cv_result_gift)
    public CardView cvResultGift;

    @BindView(R.id.civ_result_gift)
    public CircleImageView civResultGift;

    @BindView(R.id.rb_result_gift_rate)
    public RatingBar rbResultGiftRate;

    @BindView(R.id.tv_result_gift_name)
    public TextView tvResultGiftName;

    @BindView(R.id.tv_result_gift_price)
    public TextView tvResultGiftPrice;

    @BindView(R.id.tv_result_gift_store)
    public TextView tvResultGiftStore;

    public ResultGiftViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
