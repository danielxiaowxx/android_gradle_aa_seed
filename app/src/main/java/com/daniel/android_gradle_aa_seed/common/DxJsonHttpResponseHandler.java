package com.daniel.android_gradle_aa_seed.common;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 只处理后台返回格式为固定的JSON格式 {error:true, message:""}, {error:false, result:}
 */
public class DxJsonHttpResponseHandler extends JsonHttpResponseHandler {

    @Override
    public void onSuccess(final int statusCode, final Header[] headers, final String responseBody) {
        if (statusCode != HttpStatus.SC_NO_CONTENT) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        final Object jsonResponse = parseResponse(responseBody);
                        postRunnable(new Runnable() {
                            @Override
                            public void run() {
                                if (jsonResponse instanceof JSONObject) {
                                    JSONObject response = (JSONObject)jsonResponse;
                                    try {
                                        if (response.getBoolean("error")) { // 返回格式为{error:true, message:""}
                                            onFailure(new JSONException(response.getString("message")), response);
                                        } else { // 返回格式为{error:false, result:}
                                            Object result = response.get("result");
                                            if (result instanceof JSONObject) {
                                                onSuccess(statusCode, headers, (JSONObject) result);
                                            } else if (result instanceof  JSONArray) {
                                                onSuccess(statusCode, headers, (JSONArray) result);
                                            } else if (result instanceof String) {
                                                onSuccessStrResult(statusCode, headers, (String)result);
                                            } else {
                                                onFailure(new JSONException("Unexpected type " + result.getClass().getName()), (JSONObject) null);
                                            }
                                        }
                                    } catch(JSONException ex) {
                                        onFailure(new JSONException("Unexpected type " + jsonResponse.getClass().getName()), (JSONObject) null);
                                    }
                                } else {
                                    onFailure(new JSONException("Unexpected type " + jsonResponse.getClass().getName()), (JSONObject) null);
                                }

                            }
                        });
                    } catch (final JSONException ex) {
                        postRunnable(new Runnable() {
                            @Override
                            public void run() {
                                onFailure(ex, (JSONObject) null);
                            }
                        });
                    }
                }
            }).start();
        } else {
            onSuccess(statusCode, headers, new JSONObject());
        }
    }

    @Override
    public void onFailure(Throwable e, JSONObject errorResponse) {
        CommonService_.getInstance_(null).handleErrorResponse(e, errorResponse);
    }

    /**
     * 当返回的结果中的result属性的值是字符串时，调用该方法，增加该方法是为了与public void onSuccess(final int statusCode, final Header[] headers, final String responseBody)区分开
     * @param statusCode
     * @param headers
     * @param result
     */
    public void onSuccessStrResult(final int statusCode, final Header[] headers, final String result) {}
}
