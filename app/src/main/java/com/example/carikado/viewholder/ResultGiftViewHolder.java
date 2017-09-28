package com.example.carikado.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.carikado.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Faza Zulfika P P on 9/28/2017.
 */

public class ResultGiftViewHolder extends RecyclerView.ViewHolder {

    private CardView cvResultGift;
    private CircleImageView civResultGift;
    private RatingBar rbResultGiftRate;
    private TextView tvResultGiftName, tvResultGiftPrice, tvResultGiftStore;

    public ResultGiftViewHolder(View itemView) {
        super(itemView);

        cvResultGift = (CardView) itemView.findViewById(R.id.cv_result_gift);
        civResultGift = (CircleImageView) itemView.findViewById(R.id.civ_result_gift);
        rbResultGiftRate = (RatingBar) itemView.findViewById(R.id.rb_result_gift_rate);
        tvResultGiftName = (TextView) itemView.findViewById(R.id.tv_result_gift_name);
        tvResultGiftPrice = (TextView) itemView.findViewById(R.id.tv_result_gift_price);
        tvResultGiftStore = (TextView) itemView.findViewById(R.id.tv_result_gift_store);
    }

    public CardView getCvResultGift() {
        return cvResultGift;
    }

    public CircleImageView getCivResultGift() {
        return civResultGift;
    }

    public RatingBar getRbResultGiftRate() {
        return rbResultGiftRate;
    }

    public TextView getTvResultGiftName() {
        return tvResultGiftName;
    }

    public TextView getTvResultGiftPrice() {
        return tvResultGiftPrice;
    }

    public TextView getTvResultGiftStore() {
        return tvResultGiftStore;
    }
}
