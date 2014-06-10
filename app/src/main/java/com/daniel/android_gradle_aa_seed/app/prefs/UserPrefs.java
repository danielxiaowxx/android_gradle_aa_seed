package com.daniel.android_gradle_aa_seed.app.prefs;

import org.androidannotations.annotations.sharedpreferences.DefaultBoolean;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * 用户信息持久化
 */

@SharedPref
public interface UserPrefs {
    String userId();

    String userName();

    String password();

    @DefaultBoolean(false)
    boolean isLogin();
}
