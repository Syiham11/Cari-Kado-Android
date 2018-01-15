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
        void generateHelps(@NonNull List<Help> helps);
        void generateHelpEmail(@NonNull List<Help> helps);
        void generateHelpChat(@NonNull List<Help> helps);
        void generateHelpCall(@NonNull List<Help> helps);
        void showEmailHelp();
        void showChatHelp();
        void showCallHelp();
        void showHelpCard(@NonNull List<Help> helps, @NonNull Help help);
        void showHelp(@NonNull Help help);
    }

    interface Presenter extends BasePresenter {

        void loadHelps(@NonNull List<Help> helps);
        void generateHelps(@NonNull List<Help> helps);
        void openEmailHelp();
        void openChatHelp();
        void openCallHelp();
        void openHelpCard(@NonNull List<Help> helps, @NonNull Help help);
        void openHelp(@NonNull Help help);
    }
}
