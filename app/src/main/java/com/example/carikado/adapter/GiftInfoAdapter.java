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

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Faza Zulfika P P on 9/28/2017.
 */

public class GiftInfoAdapter extends RecyclerView.Adapter<GIftInfoViewHolder> {

    private ArrayList giftInfoList;
    private Context context;
    private LayoutInflater inflater;

    public GiftInfoAdapter(Context context, ArrayList giftInfoList) {
        this.context = context;
        this.giftInfoList = giftInfoList;

        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public GIftInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_gift_info, parent, false);
        return new GIftInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GIftInfoViewHolder holder, int position) {
        CardView cvGiftInfo = holder.getCvGiftInfo();
        CircleImageView civGiftInfo = holder.getCivGiftInfo();
        TextView tvGiftInfo = holder.getTvGiftInfo();

        cvGiftInfo.setOnClickListener(new GiftInfoClickListener(position));
        tvGiftInfo.setText((String) giftInfoList.get(position));
    }

    @Override
    public int getItemCount() {
        return giftInfoList.size();
    }

    private class GiftInfoClickListener implements View.OnClickListener {

        private int position;

        private GiftInfoClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, GiftInfoDetailActivity.class);
            intent.putExtra("Gift Info", (String) giftInfoList.get(position));

            context.startActivity(intent);
        }
    }
}
