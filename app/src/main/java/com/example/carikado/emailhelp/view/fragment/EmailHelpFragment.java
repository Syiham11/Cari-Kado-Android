package com.example.carikado.emailhelp.view.fragment;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carikado.R;
import com.example.carikado.emailhelp.contract.EmailHelpContract;
import com.example.carikado.emailhelp.model.EmailHelp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Merupakan class yang mengatur view dari email help
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 13 Oktober 2017
 */
public class EmailHelpFragment extends Fragment implements EmailHelpContract.View {

    @BindView(R.id.tb_email_help)
    public Toolbar mTbEmailHelp;

    @BindView(R.id.tiet_email_subject)
    public TextInputEditText mTietEmailSubject;

    @BindView(R.id.tiet_email_content)
    public TextInputEditText mTietEmailContent;

    @BindView(R.id.til_email_subject)
    public TextInputLayout mTilEmailSubject;

    @BindView(R.id.til_email_content)
    public TextInputLayout mTilEmailContent;

    @OnClick(R.id.btn_send)
    public void send() {
        EmailHelp emailHelp = new EmailHelp();

        String emailSubject = mTietEmailSubject.getText().toString();
        String emailContent = mTietEmailContent.getText().toString();

        emailHelp.setEmailSubject(emailSubject);
        emailHelp.setEmailContent(emailContent);

        mPresenter.sendEmailHelp(emailHelp);
    }

    private EmailHelpContract.Presenter mPresenter;

    public EmailHelpFragment() {
        // Default constructor
    }

    public static EmailHelpFragment newInstance() {
        return new EmailHelpFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.email_help_fragment, container, false);
        ButterKnife.bind(this, view);

        mTbEmailHelp.setTitle("");
        ((AppCompatActivity) getActivity()).setSupportActionBar(mTbEmailHelp);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        mTietEmailSubject.requestFocus();

        return view;
    }

    @Override
    public void setPresenter(@NonNull EmailHelpContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public Context getContextView() {
        return getContext();
    }

    @Override
    public void showEmailSubjectEmpty() {
        mTilEmailSubject.setErrorEnabled(true);
        mTilEmailSubject.setError(getString(R.string.email_subject_empty));
    }

    @Override
    public void hideEmailSubjectEmpty() {
        mTilEmailSubject.setErrorEnabled(false);
    }

    @Override
    public void showEmailContentEmpty() {
        mTilEmailContent.setErrorEnabled(true);
        mTilEmailContent.setError(getString(R.string.email_content_empty));
    }

    @Override
    public void hideEmailContentEmpty() {
        mTilEmailContent.setErrorEnabled(false);
    }

    @Override
    public void showEmailApplication(@NonNull EmailHelp emailHelp) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        String[] emailTo = {getString(R.string.base_email_address)};
        String emailSubject = getString(R.string.base_email_subject);

        intent.setData(Uri.parse("mailto:"));
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, emailTo);
        intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject + " " + emailHelp.getEmailSubject());
        intent.putExtra(Intent.EXTRA_TEXT, emailHelp.getEmailContent());

        try {
            startActivity(Intent.createChooser(intent, "Send email with..."));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getContext(), getString(R.string.email_not_found), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void clearAllContent() {
        mTietEmailSubject.setText("");
        mTietEmailContent.setText("");
    }
}
