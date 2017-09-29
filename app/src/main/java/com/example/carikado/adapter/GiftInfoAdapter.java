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
 * Merupakan class adapter untuk menggenerate list informasi kado
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 28 September 2017
 */

public class GiftInfoAdapter extends RecyclerView.Adapter<GIftInfoViewHolder> {

    private ArrayList giftInfoList;
    private Context context;
    private LayoutInflater inflater;

    /**
     * Constructor untuk membuat object layout inflater yang digunakna untuk menginflate layout list
     *
     * @param context merupakan context dari activity yang menggunakan list
     * @param giftInfoList merupakan list data yang akan ditampilkan
     */
    public GiftInfoAdapter(Context context, ArrayList giftInfoList) {
        this.context = context;
        this.giftInfoList = giftInfoList;

        this.inflater = LayoutInflater.from(context);
    }

    /**
     * Method yang dipanggil saat membuat view untuk item list
     *
     * @param parent merupakan parent dari setiap list item
     * @param viewType merupakan tipe view dari setiap list item
     * @return merupakan view holder dari setiap list item
     */
    @Override
    public GIftInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_gift_info, parent, false);
        return new GIftInfoViewHolder(view);
    }

    /**
     * Method yang dipanggil saat view list item telah dibuat
     *
     * @param holder merupakan holder dari setiap list item
     * @param position merupakan posisi dari list item
     */
    @Override
    public void onBindViewHolder(GIftInfoViewHolder holder, int position) {
        CardView cvGiftInfo = holder.getCvGiftInfo();
        CircleImageView civGiftInfo = holder.getCivGiftInfo();
        TextView tvGiftInfo = holder.getTvGiftInfo();

        cvGiftInfo.setOnClickListener(new GiftInfoClickListener(position));
        tvGiftInfo.setText((String) giftInfoList.get(position));
    }

    /**
     * Method untuk mengambil jumlah seluruh item list
     *
     * @return merupakan jumlah seluruh item list
     */
    @Override
    public int getItemCount() {
        return giftInfoList.size();
    }

    /**
     * Merupakan class listener saat list item di klik
     */
    private class GiftInfoClickListener implements View.OnClickListener {

        private int position;

        /**
         * Constructor yang mengambil posisi dari list item
         *
         * @param position merupakan posisi list item
         */
        private GiftInfoClickListener(int position) {
            this.position = position;
        }

        /**
         * Method yang dijalankan saat list item di klik
         *
         * @param v merupakan view yang di klik user
         */
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, GiftInfoDetailActivity.class);
            intent.putExtra("Gift Info", (String) giftInfoList.get(position));

            context.startActivity(intent);
        }
    }
}
