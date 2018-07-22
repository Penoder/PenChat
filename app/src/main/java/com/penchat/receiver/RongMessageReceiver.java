package com.penchat.receiver;

import android.content.Context;

import io.rong.push.notification.PushMessageReceiver;
import io.rong.push.notification.PushNotificationMessage;

/**
 * 广播接收器，实现在应用处于后台或者是融云服务器 disconnect 时，可以将消息通过通知的形式发送出来
 */
public class RongMessageReceiver extends PushMessageReceiver {

    /**
     * 返回 false，会弹出融云 SDK 默认通知，
     * 返回 true，融云 SDK 不会弹通知，通知需要自定义
     */
    @Override
    public boolean onNotificationMessageArrived(Context context, PushNotificationMessage pushNotificationMessage) {
        return false;
    }

    /**
     * 返回 false， 会走融云 SDK 默认处理逻辑，即点击该通知会打开会话列表或回话界面；
     * 返回 true， 则需要自己处理逻辑
     */
    @Override
    public boolean onNotificationMessageClicked(Context context, PushNotificationMessage pushNotificationMessage) {
        return false;
    }
}
