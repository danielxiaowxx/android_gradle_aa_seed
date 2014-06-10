package com.daniel.android_gradle_aa_seed.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.SystemService;

/**
 *
 */
@EBean(scope = EBean.Scope.Singleton)
public class NetwordUtil {

    @SystemService
    ConnectivityManager connectivityManager;

    public boolean isNetworkAvailable() {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        // if no network is available networkInfo will be null
        // otherwise check if we are connected
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }
}
