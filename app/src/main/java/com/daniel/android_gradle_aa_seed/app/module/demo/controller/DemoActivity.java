package com.daniel.android_gradle_aa_seed.app.module.demo.controller;

import android.support.v7.app.ActionBarActivity;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.daniel.android_gradle_aa_seed.app.R;
import com.daniel.android_gradle_aa_seed.app.module.demo.service.DemoLogicService;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_demo)
public class DemoActivity extends ActionBarActivity {

    @Bean
    DemoLogicService demoLogicService;

    // ================ widget instance ==================================================

    @ViewById(R.id.demo_email_actv)
    AutoCompleteTextView emailView;

    @ViewById(R.id.demo_password_et)
    EditText passwordView;

    // ================ life cycle event handler ==================================================

    @AfterViews
    protected void init() {
        // do something after views had been created
    }

    // ================ widget event handler ==================================================

    @Click(R.id.demo_signin_btn)
    protected void handleLoginEvent() {
        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();
        demoLogicService.doLogin(email, password);
    }

    @Click(R.id.demo_register_btn)
    protected void handleRegisterEvent() {
        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();
        demoLogicService.addUser(email, password);
    }

}
