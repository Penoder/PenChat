package com.penoder.mylibrary.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

import com.penoder.mylibrary.R;

/**
 * Created by Penoder on 17-12-23.
 */

public class ToastUtil {

    private static Toast mShortToast;

    private static Toast mLongToast;

    public static void showShortToast(Context mContext, @StringRes int resid) {
        showShortToast(mContext, mContext.getString(resid));
    }

    @SuppressLint({"InflateParams"})
    public static void showShortToast(Context mContext, String msg) {
        if (mShortToast == null) {
            mShortToast = new Toast(mContext);
            mShortToast.setDuration(Toast.LENGTH_SHORT);
        }
        TextView txtView = (TextView) LayoutInflater.from(mContext).inflate(R.layout.view_text_toast, null);
        txtView.setText(msg);
        mShortToast.setView(txtView);
        mShortToast.show();
    }

    public static void showLongToast(Context mContext, @StringRes int resid) {
        showLongToast(mContext, mContext.getString(resid));
    }

    @SuppressLint({"InflateParams"})
    public static void showLongToast(Context mContext, String msg) {
        if (mLongToast == null) {
            mLongToast = new Toast(mContext);
            mLongToast.setDuration(Toast.LENGTH_LONG);
        }
        TextView txtView = (TextView) LayoutInflater.from(mContext).inflate(R.layout.view_text_toast, null);
        txtView.setText(msg);
        mLongToast.setView(txtView);
        mLongToast.show();
    }


    public static void cancelToast() {
        if (mShortToast != null) {
            mShortToast.cancel();
        }
        if (mLongToast != null) {
            mLongToast.cancel();
        }
    }

}
