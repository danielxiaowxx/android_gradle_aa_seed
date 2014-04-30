package com.daniel.android_gradle_aa_seed.app;

import android.support.v7.app.ActionBarActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {

    @AfterViews
    protected void init() {
        // do something after views had been created
    }

}
