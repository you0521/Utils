package com.example.t.myapplication.util;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.t.myapplication.base.BaseApp;


/**
 * 爱生活，爱代码
 * 创建于：2019/1/22 15:19
 * 作 者：T
 * 微信：704003376
 */
public class ToastUtil {
    private static Toast mToast;
    //代表运行在主线程
    private static Handler mHandler = new Handler(Looper.getMainLooper());


    //长时间显示吐司
    public static void shoLongMsgToast(final int strResId) {
        //和 runOnUiThread(){};
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                //运行在主线程
                Toast.makeText(BaseApp.mContext,
                        BaseApp.mContext.getResources().getString(strResId),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    //长时间显示吐司
    public static void shoLongMsgToast(final String strMsg) {
        //和 runOnUiThread(){};
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                //运行在主线程
                Toast.makeText(BaseApp.mContext,
                        strMsg,
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    //短时间显示吐司
    public static void shoShortMsgToast(final int strResId) {
        //和 runOnUiThread(){};
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                //运行在主线程
                Toast.makeText(BaseApp.mContext,
                        BaseApp.mContext.getResources().getString(strResId),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 显示吐司
     *
     * @param text     文本
     * @param duration 显示时长
     */
    private static void showToast(CharSequence text, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(BaseApp.mContext, text, duration);
        } else {
            mToast.setText(text);
            mToast.setDuration(duration);
        }
        mToast.show();
    }


}
