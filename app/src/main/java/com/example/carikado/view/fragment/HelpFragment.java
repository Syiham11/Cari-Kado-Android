package com.example.carikado.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.carikado.R;
import com.example.carikado.view.activity.ReviewActivity;

/**
 * Created by Faza Zulfika P P on 9/27/2017.
 */

public class HelpFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_help, container, false);

        Toolbar tbHelp = (Toolbar) view.findViewById(R.id.tb_help);
        tbHelp.setTitle(R.string.help);

        ((AppCompatActivity) getActivity()).setSupportActionBar(tbHelp);

        return view;
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
                startActivity(new Intent(getContext(), ReviewActivity.class));
                return true;
            default:
                return false;
        }
    }
}
