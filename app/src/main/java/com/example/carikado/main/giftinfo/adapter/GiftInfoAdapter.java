package com.example.carikado.main.giftinfo.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.carikado.R;
import com.example.carikado.main.giftinfo.contract.GiftInfoContract;
import com.example.carikado.main.giftinfo.model.GiftInfo;
import com.example.carikado.main.giftinfo.model.GiftInfoPicture;
import com.example.carikado.main.giftinfo.viewholder.GIftInfoViewHolder;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Merupakan class adapter untuk menggenerate list informasi kado
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 28 September 2017
 */

public class GiftInfoAdapter extends RecyclerView.Adapter<GIftInfoViewHolder> {

    private ArrayList<GiftInfo> mGiftInfos;
    private Context mContext;
    private GiftInfoContract.Presenter mPresenter;
    private LayoutInflater mInflater;

    /**
     * Constructor untuk membuat object layout mInflater yang digunakna untuk menginflate layout list
     *
     * @param context   merupakan mContext dari activity yang menggunakan list
     * @param giftInfos merupakan list data yang akan ditampilkan
     */
    public GiftInfoAdapter(Context context, ArrayList<GiftInfo> giftInfos, GiftInfoContract.Presenter presenter) {
        mContext = context;
        mGiftInfos = giftInfos;
        mPresenter = presenter;

        mInflater = LayoutInflater.from(context);
    }

    /**
     * Method yang dipanggil saat membuat view untuk item list
     *
     * @param parent   merupakan parent dari setiap list item
     * @param viewType merupakan tipe view dari setiap list item
     * @return merupakan view holder dari setiap list item
     */
    @Override
    public GIftInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.gift_info_item, parent, false);
        return new GIftInfoViewHolder(view);
    }

    /**
     * Method yang dipanggil saat view list item telah dibuat
     *
     * @param holder   merupakan holder dari setiap list item
     * @param position merupakan posisi dari list item
     */
    @Override
    public void onBindViewHolder(GIftInfoViewHolder holder, int position) {
        GiftInfo giftInfo = mGiftInfos.get(position);
        List<GiftInfoPicture> giftInfoPictures = giftInfo.getGiftInfoPictures();

        CardView cvGiftInfo = holder.cvGiftInfo;
        CircleImageView civGiftInfo = holder.civGiftInfo;
        TextView tvGiftInfo = holder.tvGiftInfo;

        if (giftInfoPictures.size() > 0) {
            String url = mContext.getString(R.string.base_images_url);
            url += "gift-info/" + giftInfoPictures.get(0).getUrl();

            Glide.with(mContext).load(url).into(civGiftInfo);
        }

        cvGiftInfo.setOnClickListener(new GiftInfoClickListener(position));
        tvGiftInfo.setText(giftInfo.getTitle());
    }

    /**
     * Method untuk mengambil jumlah seluruh item list
     *
     * @return merupakan jumlah seluruh item list
     */
    @Override
    public int getItemCount() {
        return mGiftInfos.size();
    }

    /**
     * Merupakan class listener saat list item di klik
     */
    private class GiftInfoClickListener implements View.OnClickListener {

        private int mPosition;

        /**
         * Constructor yang mengambil posisi dari list item
         *
         * @param position merupakan posisi list item
         */
        private GiftInfoClickListener(int position) {
            mPosition = position;
        }

        /**
         * Method yang dijalankan saat list item di klik
         *
         * @param v merupakan view yang di klik user
         */
        @Override
        public void onClick(View v) {
            mPresenter.openGiftInfoDetail(mGiftInfos.get(mPosition));
        }
    }
}
