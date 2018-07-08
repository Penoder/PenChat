package com.penoder.penchat;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import io.rong.imlib.RongIMClient;

public class PenApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 文档是 RongIM.init(this)
        RongIMClient.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
