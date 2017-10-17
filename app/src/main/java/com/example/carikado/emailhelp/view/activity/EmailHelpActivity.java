package com.example.carikado.emailhelp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.carikado.R;
import com.example.carikado.emailhelp.presenter.EmailHelpPresenter;
import com.example.carikado.emailhelp.view.fragment.EmailHelpFragment;
import com.example.carikado.util.ActivityUtils;

public class EmailHelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_help_activity);

        EmailHelpFragment emailHelpFragment = EmailHelpFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), emailHelpFragment,
                R.id.fl_email_help);

        new EmailHelpPresenter(emailHelpFragment);
    }
}
