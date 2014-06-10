package com.daniel.android_gradle_aa_seed.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.daniel.android_gradle_aa_seed.app.R;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * 自定义Toast工具类，用该工具类代替系统默认的Toast类来显示消息
 */
@EBean(scope = EBean.Scope.Singleton)
public class AppMsgTipUtil {

    @RootContext
    Context context;

    private Toast toast = null;

    public void info(String message) {

        setText(message, R.color.info);
        setBackground(R.color.info_shallow);
        getToast().show();
    }

    public void error(String message) {
        setText(message, R.color.error);
        setBackground(R.color.error_shallow);
        getToast().show();
    }

    public void warn(String message) {
        setText(message, R.color.warn);
        setBackground(R.color.warn_shallow);
        getToast().show();
    }

    private Toast getToast() {
        if (toast == null) {
            // layout
            LinearLayout layout = new LinearLayout(context);
            layout.setPadding(12, 12, 12, 12);
            layout.setGravity(Gravity.CENTER_HORIZONTAL); // 居中

            // text
            TextView tv = new TextView(context);
            tv.setTextSize(18);
            tv.setTag("customToastTextView"); // 设置tag为了搜索该view

            layout.addView(tv);

            toast = new Toast(context);
            toast.setView(layout);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM|Gravity.FILL_HORIZONTAL, 0, 20);
        }
        return toast;
    }

    private void setText(String text, int color) {
        TextView tv = (TextView)getToast().getView().findViewWithTag("customToastTextView");
        tv.setText(text);
        tv.setTextColor(context.getResources().getColor(color));
    }

    private void setBackground(int color) {
        getToast().getView().setBackgroundColor(context.getResources().getColor(color));
    }

}
