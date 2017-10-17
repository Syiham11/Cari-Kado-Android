package com.example.carikado.main.help.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carikado.R;
import com.example.carikado.main.help.contract.HelpContract;
import com.example.carikado.main.help.model.Help;
import com.example.carikado.main.help.viewholder.HelpViewHolder;

import java.util.ArrayList;

/**
 * Merupakan adapter yang mengatur item yang ditampilkan oleh recycler view help
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 12 Oktober 2017
 */
public class HelpAdapter extends RecyclerView.Adapter<HelpViewHolder> {

    private ArrayList<Help> mHelps;
    private Context mContext;
    private HelpContract.Presenter mPresenter;
    private LayoutInflater mInflater;

    public HelpAdapter(Context context, ArrayList<Help> helps, HelpContract.Presenter presenter) {
        mHelps = helps;
        mContext = context;
        mPresenter = presenter;

        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public HelpViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.help_item, parent, false);
        return new HelpViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HelpViewHolder holder, int position) {
        Help help = mHelps.get(position);

        holder.mIvHelpActive.setImageResource(help.getImageBig());
        holder.mIvHelpInactive.setImageResource(help.getImageSmall());
        holder.mTvHelpActive.setText(help.getName());
        holder.mTvHelpInactive.setText(help.getName());
        holder.mTvHelpDesc.setText(help.getDesc());
        holder.mRvHelp.setBackgroundColor(help.getColor());

        holder.mRvHelp.setOnClickListener(new CardClickListener(help));
        holder.mBtnHelp.setOnClickListener(new HelpClickListener(help));

        if (help.isActive()) {
            holder.mLlActive.setVisibility(View.VISIBLE);
            holder.mLlInactive.setVisibility(View.GONE);
        } else {
            holder.mLlActive.setVisibility(View.GONE);
            holder.mLlInactive.setVisibility(View.VISIBLE);
        }

        ViewGroup.LayoutParams params = holder.mRvHelp.getLayoutParams();

        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;

        holder.mRvHelp.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return mHelps.size();
    }

    private class CardClickListener implements View.OnClickListener {

        private Help mHelp;

        private CardClickListener(Help help) {
            mHelp = help;
        }

        @Override
        public void onClick(View v) {
            mPresenter.openHelpCard(mHelps, mHelp);
        }
    }

    private class HelpClickListener implements View.OnClickListener {

        private Help mHelp;

        private HelpClickListener(Help help) {
            mHelp = help;
        }

        @Override
        public void onClick(View v) {
            mPresenter.openHelp(mHelp);
        }
    }
}
