package com.daniel.android_gradle_aa_seed.app;

import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_demo)
public class DemoActivity extends ActionBarActivity {

    @ViewById(R.id.demoHelloTxt)
    TextView helloTxtView;

    @AfterViews
    protected void init() {
        // do something after views had been created
        helloTxtView.setText("hello daniel");
    }

}
