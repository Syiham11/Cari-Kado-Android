package com.example.carikado.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.carikado.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Faza Zulfika P P on 9/28/2017.
 */

public class GIftInfoViewHolder extends RecyclerView.ViewHolder {

    private CardView cvGiftInfo;
    private CircleImageView civGiftInfo;
    private TextView tvGiftInfo;

    public GIftInfoViewHolder(View itemView) {
        super(itemView);

        cvGiftInfo = (CardView) itemView.findViewById(R.id.cv_gift_info);
        civGiftInfo = (CircleImageView) itemView.findViewById(R.id.civ_gift_info);
        tvGiftInfo = (TextView) itemView.findViewById(R.id.tv_gift_info);
    }

    public CardView getCvGiftInfo() {
        return cvGiftInfo;
    }

    public CircleImageView getCivGiftInfo() {
        return civGiftInfo;
    }

    public TextView getTvGiftInfo() {
        return tvGiftInfo;
    }
}
