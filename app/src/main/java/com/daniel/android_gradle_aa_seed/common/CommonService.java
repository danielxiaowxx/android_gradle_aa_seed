package com.daniel.android_gradle_aa_seed.common;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Daniel on 14-5-28.
 */
@EBean(scope = EBean.Scope.Singleton)
public class CommonService {

    @RootContext
    Context context;

    /**
     * 处理错误提示
     * @param e
     */
    @UiThread
    public void handleErrorResponse(Throwable e, JSONObject errorResponse) {
        // TODO Daniel 请根据实际交互设计修改此处
        Toast.makeText(context,e.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
