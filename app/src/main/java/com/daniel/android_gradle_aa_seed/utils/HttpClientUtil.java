package com.daniel.android_gradle_aa_seed.utils;

import com.daniel.android_gradle_aa_seed.app.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.res.IntegerRes;
import org.androidannotations.annotations.res.StringRes;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用该HttpClientUtil的service的方法不能用background线程，因为该类的方法会自己发起一个线程
 */
@EBean(scope = EBean.Scope.Singleton)
public class HttpClientUtil {

    // 配置 (配置值在config.xml中修改)
    @StringRes(R.string.http_base_url)
    String httpBaseUrl;
    @StringRes(R.string.user_agent)
    String userAgent;
    @IntegerRes(R.integer.keep_alive_time)
    int keepAliveTime; // 线程池维护线程所允许的空闲时间
    @IntegerRes(R.integer.core_pool_size)
    int corePoolSize; // 线程池维护线程的最少数量
    @IntegerRes(R.integer.max_pool_size)
    int maxPoolSize; // 线程池维护线程的最大数量

    private AsyncHttpClient client = null;

    @AfterInject
    public void init() {
        client = new AsyncHttpClient();

        if (!StringUtils.isEmpty(userAgent)) {
            client.setUserAgent(userAgent);
        }

        /* set thread pool */
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(maxPoolSize);
        // handler有四个选择：
        // ThreadPoolExecutor.AbortPolicy()
        // 抛出java.util.concurrent.RejectedExecutionException异常
        // ThreadPoolExecutor.CallerRunsPolicy()
        // 重试添加当前的任务，他会自动重复调用execute()方法
        // ThreadPoolExecutor.DiscardOldestPolicy()
        // 抛弃旧的任务
        // ThreadPoolExecutor.DiscardPolicy()
        // 抛弃当前的任务
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS, blockingQueue, rejectedExecutionHandler);
        client.setThreadPool(executor);
    }

    public void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private String getAbsoluteUrl(String relativeUrl) {
        return httpBaseUrl + relativeUrl;
    }
}
