package com.example.carikado.main.help.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.carikado.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Merupakan viewholder untuk item dari item help
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 11 Oktober 2017
 */
public class HelpViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.btn_help)
    public Button mBtnHelp;

    @BindView(R.id.rv_help)
    public RelativeLayout mRvHelp;

    @BindView(R.id.ll_inactive)
    public LinearLayout mLlInactive;

    @BindView(R.id.ll_active)
    public LinearLayout mLlActive;

    @BindView(R.id.iv_help_active)
    public ImageView mIvHelpActive;

    @BindView(R.id.iv_help_inactive)
    public ImageView mIvHelpInactive;

    @BindView(R.id.tv_help_active)
    public TextView mTvHelpActive;

    @BindView(R.id.tv_help_inactive)
    public TextView mTvHelpInactive;

    @BindView(R.id.tv_help_desc)
    public TextView mTvHelpDesc;

    public HelpViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
