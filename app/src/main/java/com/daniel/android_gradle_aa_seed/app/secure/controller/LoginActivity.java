package com.daniel.android_gradle_aa_seed.app.secure.controller;

import android.support.v7.app.ActionBarActivity;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.daniel.android_gradle_aa_seed.app.R;
import com.daniel.android_gradle_aa_seed.app.secure.service.LoginLogicService;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_login)
public class LoginActivity extends ActionBarActivity {

    @Bean
    LoginLogicService loginLogicService;

    // ================ widget instance ==================================================

    @ViewById(R.id.email)
    AutoCompleteTextView emailView;

    @ViewById(R.id.password)
    EditText passwordView;

    // ================ life cycle event handler ==================================================

    @AfterViews
    protected void init() {
        // do something after views had been created
    }

    // ================ widget event handler ==================================================

    @Click(R.id.email_sign_in_button)
    protected void handleLoginEvent() {
        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();
        loginLogicService.doLogin(email, password);
    }

}
