package com.daniel.android_gradle_aa_seed.common;

import android.app.Application;
import android.content.res.Configuration;

import com.daniel.android_gradle_aa_seed.app.R;
import com.daniel.android_gradle_aa_seed.app.prefs.ConfigPrefs_;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EApplication;
import org.androidannotations.annotations.sharedpreferences.Pref;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

/**
 * Created by Daniel on 14-5-26.
 */
@ReportsCrashes(formKey = "", // will not be used
        mailTo = "daniel.xiao@corp.globalmarket.com",
        mode = ReportingInteractionMode.TOAST,
        resToastText = R.string.crash_toast_text)
@EApplication
public class MyApplication extends Application {

    @Pref
    ConfigPrefs_ configPrefs;

    @Bean
    CommonService commonService; // 初始化CommonService单例对象

    @Override
    public void onCreate() {
        super.onCreate();

        // The following line triggers the initialization of ACRA
        ACRA.init(this);
    }

    @AfterInject
    public void beforeInit() {
        String language = configPrefs.language().get();
        if (StringUtils.isNotEmpty(language)) {
            changeLanguage(language);
        }
    }

    /**
     * 改变本应用的语言环境
     * @param language
     */
    public void changeLanguage(String language) {
        String languageToLoad = language;
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        this.getBaseContext().getResources().updateConfiguration(config, null);
    }

}
