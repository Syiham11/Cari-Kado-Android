package com.example.carikado.giftinfodetail.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.carikado.R;
import com.example.carikado.main.giftinfo.model.GiftInfoPicture;

import java.util.ArrayList;

/**
 * Created by Faza Zulfika P P on 1/16/2018.
 */

public class GiftInfoPictureAdapter extends PagerAdapter {

    private ArrayList<GiftInfoPicture> mGiftInfoPictures;
    private Context context;
    private LayoutInflater inflater;

    public GiftInfoPictureAdapter(Context context, ArrayList<GiftInfoPicture> giftInfoPictures) {
        this.context = context;
        this.mGiftInfoPictures = giftInfoPictures;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mGiftInfoPictures.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.gift_info_detail_picture_item, container, false);

        GiftInfoPicture giftInfoPicture = mGiftInfoPictures.get(position);
        ImageView ivImage = view.findViewById(R.id.iv_image);

        String url = context.getString(R.string.base_images_url);
        url += "gift-info/" + giftInfoPicture.getUrl();

        Glide.with(context).load(url).into(ivImage);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
