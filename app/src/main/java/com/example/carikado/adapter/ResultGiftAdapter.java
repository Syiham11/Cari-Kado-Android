package com.example.carikado.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carikado.R;
import com.example.carikado.viewholder.ResultGiftViewHolder;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Faza Zulfika P P on 10/3/2017.
 */

public class ResultGiftAdapter extends RecyclerView.Adapter<ResultGiftViewHolder> {

    private ArrayList giftList;
    private Context context;
    private LayoutInflater inflater;

    public ResultGiftAdapter(Context context, ArrayList giftList) {
        this.giftList = giftList;
        this.context = context;

        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ResultGiftViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_result_gift, parent, false);
        return new ResultGiftViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ResultGiftViewHolder holder, int position) {
        CardView cvResultGift = holder.getCvResultGift();

        cvResultGift.setOnClickListener(new ResultGiftClickListener(position));
        holder.getRbResultGiftRate().setNumStars(new Random().nextInt(5) + 1);
        holder.getTvResultGiftName().setText((String) giftList.get(position));
        holder.getTvResultGiftPrice().setText((String) giftList.get(position));
        holder.getTvResultGiftStore().setText((String) giftList.get(position));
    }

    @Override
    public int getItemCount() {
        return giftList.size();
    }

    private class ResultGiftClickListener implements View.OnClickListener {

        private int position;

        private ResultGiftClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            // Do nothing
        }
    }
}
