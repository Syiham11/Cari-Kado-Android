package com.example.carikado.main.help.contract;

import android.support.annotation.NonNull;

import com.example.carikado.base.BasePresenter;
import com.example.carikado.base.BaseView;
import com.example.carikado.main.help.model.Help;

import java.util.List;

/**
 * Merupakan class yang mengatur hubungan view dan presenter pada help
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public interface HelpContract {

    interface View extends BaseView<Presenter> {

        void showHelps();
        void generateHelps(@NonNull List helps);
        void generateHelpEmail(@NonNull List helps);
        void generateHelpChat(@NonNull List helps);
        void generateHelpCall(@NonNull List helps);
        void showEmailHelp();
        void showChatHelp();
        void showCallHelp();
        void showReview();
        void showHelpCard(@NonNull List helps, @NonNull Help help);
        void showHelp(@NonNull Help help);
    }

    interface Presenter extends BasePresenter {

        void loadHelps(@NonNull List helps);
        void generateHelps(@NonNull List helps);
        void openEmailHelp();
        void openChatHelp();
        void openCallHelp();
        void openHelpCard(@NonNull List helps, @NonNull Help help);
        void openHelp(@NonNull Help help);
        void openReview();
    }
}
