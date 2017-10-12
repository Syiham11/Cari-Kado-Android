package com.example.carikado.main.giftinfo.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.carikado.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Merupakan viewholder untuk item dari item gift info
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 12 Oktober 2017
 */
public class GIftInfoViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.cv_gift_info)
    public CardView cvGiftInfo;

    @BindView(R.id.civ_gift_info)
    public CircleImageView civGiftInfo;

    @BindView(R.id.tv_gift_info)
    public TextView tvGiftInfo;

    public GIftInfoViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
