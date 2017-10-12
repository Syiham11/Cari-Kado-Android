package com.example.carikado.main.help.presenter;

import android.support.annotation.NonNull;

import com.example.carikado.main.help.contract.HelpContract;
import com.example.carikado.main.help.model.Help;

import java.util.ArrayList;
import java.util.List;

/**
 * Merupakan presenter yang mengatur logic dari help
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public class HelpPresenter implements HelpContract.Presenter {

    private HelpContract.View mView;

    public HelpPresenter(HelpContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void onCreate() {
        // Do nothing
    }

    @Override
    public void onStart() {
        mView.showHelps();
    }

    @Override
    public void onResume() {
        // DO nothing
    }

    @Override
    public void onPause() {
        // Do nothing
    }

    @Override
    public void onStop() {
        // DO nothing
    }

    @Override
    public void onDestroy() {
        // Do nothing
    }

    @Override
    public void loadHelps(@NonNull List helps) {
        mView.generateHelps(helps);
    }

    @Override
    public void generateHelps(@NonNull List helps) {
        mView.generateHelpEmail(helps);
        mView.generateHelpChat(helps);
        mView.generateHelpCall(helps);
    }

    @Override
    public void openEmailHelp() {
        mView.showEmailHelp();
    }

    @Override
    public void openChatHelp() {
        mView.showChatHelp();
    }

    @Override
    public void openCallHelp() {
        mView.showCallHelp();
    }

    @Override
    public void openReview() {
        mView.showReview();
    }

    @Override
    public void openHelpCard(@NonNull List helps, @NonNull Help help) {
        ArrayList<Help> helpArrayList = (ArrayList) helps;

        for (Help h : helpArrayList) {
            if (!h.getName().equals(help.getName()))
                h.setIsActive(false);
        }

        mView.showHelpCard(helps, help);
    }

    @Override
    public void openHelp(@NonNull Help help) {
        mView.showHelp(help);
    }
}
