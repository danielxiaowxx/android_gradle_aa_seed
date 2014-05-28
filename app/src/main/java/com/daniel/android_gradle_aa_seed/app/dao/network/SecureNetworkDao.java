package com.daniel.android_gradle_aa_seed.app.dao.network;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.HttpsClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.params.DefaultedHttpParams;
import org.apache.http.params.HttpParams;

/**
 * Created by Daniel on 14-5-7.
 */
@EBean
public class SecureNetworkDao {

    @HttpsClient
    HttpClient httpClient;

    public Object login(String userName, String password){
        try {
            HttpGet httpget = new HttpGet("http://192.168.88.107:8080/demo/sayHello");
            httpget.getParams().setParameter("name", userName);
            HttpResponse response = httpClient.execute(httpget);
            return response.getEntity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
