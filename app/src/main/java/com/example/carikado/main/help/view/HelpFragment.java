package com.example.carikado.main.help.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.carikado.R;
import com.example.carikado.emailhelp.view.activity.EmailHelpActivity;
import com.example.carikado.main.help.adapter.HelpAdapter;
import com.example.carikado.main.help.contract.HelpContract;
import com.example.carikado.main.help.model.Help;
import com.example.carikado.review.view.activity.ReviewActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Merupakan tampilan untuk bantuan
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 27 September 2017
 */
public class HelpFragment extends Fragment implements HelpContract.View {

    private static final int PHONE_CALL_PERMISSION_REQUEST_CODE = 9167;

    @BindView(R.id.tb_help)
    public Toolbar mTbHelp;

    @BindView(R.id.rv_help)
    public RecyclerView mRvHelp;

    private ArrayList<Help> mHelps;
    private HelpAdapter mAdapter;
    private HelpContract.Presenter mHelpPresenter;

    public HelpFragment() {
        // Default Constructor
    }

    public static HelpFragment newInstance() {
        return new HelpFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.help_fragment, container, false);
        ButterKnife.bind(this, view);

        mTbHelp.setTitle("");
        ((AppCompatActivity) getActivity()).setSupportActionBar(mTbHelp);

        mRvHelp.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvHelp.setHasFixedSize(true);
        mRvHelp.setNestedScrollingEnabled(false);

        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PHONE_CALL_PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    mHelpPresenter.openCallHelp();
                break;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.help_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.menu_review:
                mHelpPresenter.openReview();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mHelpPresenter.onStart();
    }

    @Override
    public void setPresenter(@NonNull HelpContract.Presenter presenter) {
        mHelpPresenter = presenter;
    }

    @Override
    public void showHelps() {
        if (mHelps == null) {
            mHelps = new ArrayList<>();
            mHelpPresenter.loadHelps(mHelps);
        }

        if (mAdapter == null)
            mAdapter = new HelpAdapter(getContext(), mHelps, mHelpPresenter);

        mRvHelp.setAdapter(mAdapter);
    }

    @Override
    public void showEmailHelp() {
        Intent intent = new Intent(getContext(), EmailHelpActivity.class);
        startActivity(intent);
    }

    @Override
    public void showChatHelp() {
        // TODO show chat help activity
    }

    @Override
    public void showCallHelp() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + getString(R.string.base_phone_number)));

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED)
            startActivity(intent);
        else
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.CALL_PHONE},
                    PHONE_CALL_PERMISSION_REQUEST_CODE);
    }

    @Override
    public void showReview() {
        Intent intent = new Intent(getContext(), ReviewActivity.class);
        startActivity(intent);
    }

    @Override
    public void showHelpCard(@NonNull List helps, @NonNull Help help) {
        help.setIsActive(!help.isActive());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showHelp(@NonNull Help help) {
        String name = help.getName();

        if (name.equals(getString(R.string.email)))
            mHelpPresenter.openEmailHelp();

        if (name.equals(getString(R.string.chat)))
            mHelpPresenter.openChatHelp();

        if (name.equals(getString(R.string.call)))
            mHelpPresenter.openCallHelp();
    }

    @Override
    public void generateHelps(@NonNull List helps) {
        mHelpPresenter.generateHelps(helps);
    }

    @Override
    public void generateHelpEmail(@NonNull List helps) {
        Help help = new Help();
        int color = ContextCompat.getColor(getContext(), R.color.colorEmail);

        help.setName(getString(R.string.email));
        help.setDesc("Deskripsinya masih dibikin, sabar ya");
        help.setImageSmall(R.drawable.ic_help_mail);
        help.setImageBig(R.drawable.ic_help_mail_big);
        help.setColor(color);
        help.setIsActive(false);

        helps.add(help);
    }

    @Override
    public void generateHelpChat(@NonNull List helps) {
        Help help = new Help();
        int color = ContextCompat.getColor(getContext(), R.color.colorChat);

        help.setName(getString(R.string.chat));
        help.setDesc("Deskripsinya masih dibikin, sabar ya");
        help.setImageSmall(R.drawable.ic_help_chat);
        help.setImageBig(R.drawable.ic_help_chat_big);
        help.setColor(color);
        help.setIsActive(false);

        helps.add(help);
    }

    @Override
    public void generateHelpCall(@NonNull List helps) {
        Help help = new Help();
        int color = ContextCompat.getColor(getContext(), R.color.colorAccent);

        help.setName(getString(R.string.call));
        help.setDesc("Deskripsinya masih dibikin, sabar ya");
        help.setImageSmall(R.drawable.ic_help_call);
        help.setImageBig(R.drawable.ic_help_call_big);
        help.setColor(color);
        help.setIsActive(false);

        helps.add(help);
    }
}
