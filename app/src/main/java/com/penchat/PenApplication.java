package com.penchat;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.penchat.im.MyReceiveMsgListener;

import io.rong.imlib.RongIMClient;

public class PenApplication extends Application {

    private static PenApplication application;

    public static PenApplication getInstance() {
        if (application == null) {
            synchronized (PenApplication.class) {
                if (application == null) {
                    application = new PenApplication();
                }
            }
        }
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 文档是 RongIM.init(this)
        RongIMClient.init(this);
        // (Message message, int i
        RongIMClient.setOnReceiveMessageListener(new MyReceiveMsgListener());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
