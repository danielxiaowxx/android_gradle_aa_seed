package com.daniel.android_gradle_aa_seed.utils;

import android.util.Log;

import org.androidannotations.api.sharedpreferences.SharedPreferencesHelper;
import org.androidannotations.api.sharedpreferences.StringPrefField;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.Iterator;

/**
 *
 */
public class BeanUtil {

    /**
     * 将JSON对象的值复制到SharedPreferencesHelper对象中
     * (注意：无论JSON对象的值为任何类型，都以String的类型复制到SharedPreferencesHelper对象中去)
     * @param sourceObj
     * @param destObj
     */
    public static void copyJsonToPrefs(JSONObject sourceObj, SharedPreferencesHelper destObj) {
        Method[] methods = destObj.getClass().getMethods();
        int length = methods.length;

        Iterator<String> keys = sourceObj.keys();

        try {
            while (keys.hasNext()) {
                String key = keys.next();

                for (int i = 0; i < length; i++) {
                    Method method = methods[i];
                    if (StringUtils.equals(key, method.getName())) {
                        StringPrefField stringField = (StringPrefField)method.invoke(destObj);
                        stringField.put(sourceObj.getString(key));
                        break;
                    }
                }
            }

        } catch (Exception ex) {
            Log.e("BeanUtil.copyJsonToPrefs", ex.getMessage());
        }
    }

}
