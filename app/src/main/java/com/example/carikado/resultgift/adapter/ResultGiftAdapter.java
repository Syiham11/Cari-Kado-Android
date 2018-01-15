package com.example.carikado.resultgift.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.carikado.R;
import com.example.carikado.resultgift.contract.ResultGiftContract;
import com.example.carikado.resultgift.model.Gift;
import com.example.carikado.resultgift.viewholder.ResultGiftViewHolder;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Faza Zulfika P P on 10/3/2017.
 */

public class ResultGiftAdapter extends RecyclerView.Adapter<ResultGiftViewHolder> {

    private ArrayList<Gift> mGifts;
    private Context mContext;
    private LayoutInflater mInflater;
    private NumberFormat mNumberFormat;
    private ResultGiftContract.Presenter mPresenter;

    public ResultGiftAdapter(Context context, ArrayList<Gift> gifts, ResultGiftContract.Presenter presenter) {
        mGifts = gifts;
        mContext = context;
        mPresenter = presenter;

        mInflater = LayoutInflater.from(context);
        mNumberFormat = NumberFormat.getNumberInstance(Locale.GERMAN);
    }

    @Override
    public ResultGiftViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.result_gift_item, parent, false);
        return new ResultGiftViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ResultGiftViewHolder holder, int position) {
        CardView cvResultGift = holder.cvResultGift;
        CircleImageView civResultGift = holder.civResultGift;
        RatingBar rbResultGiftRate = holder.rbResultGiftRate;
        TextView tvResultGiftName = holder.tvResultGiftName;
        TextView tvResultGiftPrice = holder.tvResultGiftPrice;
        TextView tvResultGiftStore = holder.tvResultGiftStore;

        Gift gift = mGifts.get(position);

        Glide.with(mContext).load(gift.getGiftPictures().get(0).getUrl()).into(civResultGift);

        String price = "Rp. " + mNumberFormat.format(gift.getPrice()) + ",-";

        rbResultGiftRate.setNumStars(gift.getRating());
        tvResultGiftName.setText(gift.getName());
        tvResultGiftPrice.setText(price);
        tvResultGiftStore.setText(gift.getStore());

        cvResultGift.setOnClickListener(new ResultGiftClickListener(position));
    }

    @Override
    public int getItemCount() {
        return mGifts.size();
    }

    private class ResultGiftClickListener implements View.OnClickListener {

        private int mPosition;

        private ResultGiftClickListener(int position) {
            mPosition = position;
        }

        @Override
        public void onClick(View v) {
            Gift gift = mGifts.get(mPosition);
            mPresenter.openGiftDetail(gift);
        }
    }
}
