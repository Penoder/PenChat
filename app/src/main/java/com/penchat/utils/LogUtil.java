package com.penchat.utils;

import android.text.TextUtils;
import android.util.Log;

import com.penchat.BuildConfig;

/**
 * 打印日志工具类,实现在Debug环境下打印日志,真实环境不打印
 *
 * @author Penoder
 * @date 2017/12/02
 */
public class LogUtil {

    private static final String TAG = "Penoder";
    private static final boolean IS_DEBUG = BuildConfig.ENV_TYPE == 0;

    public static void d(String msg) {
        if (IS_DEBUG) {
            Log.d(TAG, TextUtils.isEmpty(msg) ? "" : msg);
        }
    }

    public static void i(String msg) {
        if (IS_DEBUG) {
            Log.i(TAG, TextUtils.isEmpty(msg) ? "" : msg);
        }
    }

    public static void e(String msg) {
        if (IS_DEBUG) {
            Log.e(TAG, TextUtils.isEmpty(msg) ? "" : msg);
        }
    }

    public static void d(String TAG, String msg) {
        if (IS_DEBUG) {
            Log.d(TAG, TextUtils.isEmpty(msg) ? "" : msg);
        }
    }

    public static void i(String TAG, String msg) {
        if (IS_DEBUG) {
            Log.i(TAG, TextUtils.isEmpty(msg) ? "" : msg);
        }
    }

    public static void e(String TAG, String msg) {
        if (IS_DEBUG) {
            Log.e(TAG, TextUtils.isEmpty(msg) ? "" : msg);
        }
    }
}