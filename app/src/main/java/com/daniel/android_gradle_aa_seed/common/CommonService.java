package com.daniel.android_gradle_aa_seed.common;

import com.daniel.android_gradle_aa_seed.utils.AppMsgTipUtil;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;
import org.json.JSONObject;

/**
 *
 */
@EBean(scope = EBean.Scope.Singleton)
public class CommonService {

    @Bean
    AppMsgTipUtil appMsgTipUtil;

    /**
     * 处理错误提示
     * @param e
     */
    @UiThread
    public void handleErrorResponse(Throwable e, JSONObject errorResponse) {
        // TODO Daniel 请根据实际交互设计修改此处
        appMsgTipUtil.error(e.getMessage());
    }

}
