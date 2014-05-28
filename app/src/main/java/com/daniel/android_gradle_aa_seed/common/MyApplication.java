package com.daniel.android_gradle_aa_seed.common;

import android.app.Application;

import com.daniel.android_gradle_aa_seed.app.R;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

/**
 * Created by Daniel on 14-5-26.
 */
@ReportsCrashes(formKey = "", // will not be used
        mailTo = "daniel.xiao@corp.globalmarket.com",
        mode = ReportingInteractionMode.TOAST,
        resToastText = R.string.crash_toast_text)
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // The following line triggers the initialization of ACRA
        ACRA.init(this);
    }
}
