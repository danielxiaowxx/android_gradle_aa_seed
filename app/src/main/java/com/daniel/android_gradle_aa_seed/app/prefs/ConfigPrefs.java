package com.daniel.android_gradle_aa_seed.app.prefs;

import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * 程序配置信息持久化
 */
@SharedPref
public interface ConfigPrefs {

    String language();
}
