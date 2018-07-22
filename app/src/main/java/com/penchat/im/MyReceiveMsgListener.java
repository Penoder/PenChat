package com.penchat.im;

import android.util.Log;

import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;

public class MyReceiveMsgListener implements RongIMClient.OnReceiveMessageListener {

    @Override
    public boolean onReceived(Message message, int i) {
        Log.i("Penoder", "onReceived: " + message.getContent() + " ----  " + message.getConversationType());
        return false;
    }
}
