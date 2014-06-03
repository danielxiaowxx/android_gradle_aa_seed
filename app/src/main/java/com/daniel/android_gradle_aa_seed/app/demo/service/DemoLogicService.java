package com.daniel.android_gradle_aa_seed.app.demo.service;

import com.daniel.android_gradle_aa_seed.app.dao.db.DaoManager;
import com.daniel.android_gradle_aa_seed.app.dao.db.User;
import com.daniel.android_gradle_aa_seed.common.CommonService;
import com.daniel.android_gradle_aa_seed.common.DxJsonHttpResponseHandler;
import com.daniel.android_gradle_aa_seed.utils.HttpClientUtil;
import com.loopj.android.http.RequestParams;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.apache.http.Header;

import java.util.Date;

/**
 * Created by Daniel on 14-5-5.
 */

@EBean
public class DemoLogicService {

    @Bean
    CommonService commonService;

    @Bean
    DemoViewService loginViewService;

    @Bean
    HttpClientUtil httpClientUtil;

    @Bean
    DaoManager daoManager;

    public void doLogin(String username, String password) {
        RequestParams params = new RequestParams();
        params.put("name", username);
        httpClientUtil.post("demo/sayHello", params, new DxJsonHttpResponseHandler() {

            // response中有意义的返回结果为字符串，如{error:true, result:"hello daniel"}
            @Override
            public void onSuccessStrResult(int statusCode, Header[] headers, String result) {
                loginViewService.doLoginSuccess(result);
            }

            // response中有意义的返回结果为JSONObject，如{error:true, result:{name:"daniel"}}
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                super.onSuccess(statusCode, headers, response);
//            }

            // response中有意义的返回结果为JSONArray，如{error:true, result:[1, 2]}
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
//                super.onSuccess(statusCode, headers, response);
//            }

            // 默认错误由CommonService.handleErrorResponse处理，如果想自定义，覆盖onFailure(Throwable e, JSONObject errorResponse)即可
//            @Override
//            public void onFailure(Throwable e, JSONObject errorResponse) {
//                loginViewService.doLoginFail();
//            }
        });
    }

    @Background
    public void addUser(String username, String password) {
        User user = new User(null, username, password, new Date());
        daoManager.getUserDao().insert(user);
        loginViewService.doAddUserSuccess(user.getId());
    }

}
