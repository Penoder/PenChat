package com.penchat.ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.penoder.mylibrary.utils.SPUtils;
import com.penchat.R;
import com.penchat.api.ChatApi;
import com.penchat.api.SPKeyWord;
import com.penchat.databinding.ActivitySplashBinding;
import com.penchat.ui.base.BaseActivity;
import com.penchat.utils.LogUtil;
import com.penchat.utils.okhttp.OkCallBack;
import com.penchat.utils.okhttp.OkHttpManager;
import com.penoder.mylibrary.utils.ToastUtil;

import io.rong.imlib.RongIMClient;

public class SplashActivity extends BaseActivity<ActivitySplashBinding> {
    @Override
    protected int getLayoutID() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        super.initView();
        if (!TextUtils.isEmpty((String) SPUtils.get(mContext, SPKeyWord.IM_TOKEN, ""))) {
            startActivity(new Intent(mContext, MainTabActivity.class));
            finish();
        } else {
            OkHttpManager.create(mContext)
                    .addUrl(ChatApi.Companion.getCONNECT_IM())
                    .sign()
                    .addParam("user_id", "1")
                    .execute((OkCallBack<String>) (isSuccess, data) -> {
                        if (isSuccess) {
                            Log.i("Penoder", "initData: " + data);
                            connect(data);
                        } else {
                            Log.i("Penoder", "initData: 卧槽");
                        }
                    });
        }
    }

    /**
     * 连接服务器，在整个应用程序全局，只需要调用一次，需在 RongIMClient.init(Context)} 之后调用
     * 如果调用此接口遇到连接失败，SDK 会自动启动重连机制进行最多10次重连，分别是1, 2, 4, 8, 16, 32, 64, 128, 256, 512秒后。
     * 在这之后如果仍没有连接成功，还会在当检测到设备网络状态变化时再次进行重连。
     *
     * @param token 从服务端获取的用户身份令牌（Token）。
     * @return RongIM  客户端核心类的实例。
     */
    private void connect(String token) {
        RongIMClient.connect(token, new RongIMClient.ConnectCallback() {

            /**
             * Token 错误。可以从下面两点检查 1.  Token 是否过期，如果过期您需要向 App Server 重新请求一个新的 Token
             *                  2.  token 对应的 appKey 和工程里设置的 appKey 是否一致
             */
            @Override
            public void onTokenIncorrect() {
                ToastUtil.showShortToast(mContext, "Token 错误");
            }

            /**
             * 连接融云成功
             * @param userid 当前 token 对应的用户 id
             */
            @Override
            public void onSuccess(String userid) {
                LogUtil.i("onSuccess: " + userid);
                SPUtils.put(mContext, SPKeyWord.IM_TOKEN, token);
                startActivity(new Intent(mContext, MainTabActivity.class));
                finish();
            }

            /**
             * 连接融云失败
             * @param errorCode 错误码，可到官网 查看错误码对应的注释
             */
            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                LogUtil.i("onError: " + errorCode.getMessage());
                ToastUtil.showShortToast(mContext, errorCode.getMessage());
            }
        });
    }
}
