package com.daniel.android_gradle_aa_seed.app.module.demo.service;

import android.widget.TextView;

import com.daniel.android_gradle_aa_seed.app.R;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Daniel on 14-5-5.
 */

@EBean
public class DemoViewService {

    @ViewById(R.id.demo_tip_tv)
    TextView tipTextView;

    @UiThread
    public void doLoginSuccess(String msg) {
        tipTextView.setText("OK:" + msg);
    }

    @UiThread
    public void doLoginFail(String msg) {
        tipTextView.setText("Fail:" + msg);
    }

    @UiThread
    public void doAddUserSuccess(Long userId) {
        tipTextView.setText("Add UserId:" + userId);
    }

}
