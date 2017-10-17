package com.example.carikado.emailhelp.presenter;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.carikado.emailhelp.contract.EmailHelpContract;
import com.example.carikado.emailhelp.model.EmailHelp;

/**
 * Merupakan presenter yang mengatur logic dari email help
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 13 Oktober 2017
 */
public class EmailHelpPresenter implements EmailHelpContract.Presenter {

    private EmailHelpContract.View mView;

    public EmailHelpPresenter(EmailHelpContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void onCreate() {
        // Do Nothing
    }

    @Override
    public void onStart() {
        // Do Nothing
    }

    @Override
    public void onResume() {
        // Do Nothing
    }

    @Override
    public void onPause() {
        // Do Nothing
    }

    @Override
    public void onStop() {
        // Do Nothing
    }

    @Override
    public void onDestroy() {
        // Do Nothing
    }

    @Override
    public void sendEmailHelp(@NonNull EmailHelp emailHelp) {
        boolean isValid = true;

        if (TextUtils.isEmpty(emailHelp.getEmailSubject())) {
            mView.showEmailSubjectEmpty();
            isValid = false;
        } else
            mView.hideEmailSubjectEmpty();

        if (TextUtils.isEmpty(emailHelp.getEmailContent())) {
            mView.showEmailContentEmpty();
            isValid = false;
        } else
            mView.hideEmailContentEmpty();

        if (isValid) {
            mView.showEmailApplication(emailHelp);
            mView.clearAllContent();
        }
    }
}
