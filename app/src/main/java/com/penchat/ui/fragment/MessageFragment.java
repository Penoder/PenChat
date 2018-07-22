package com.penchat.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.penchat.PenApplication;
import com.penchat.entity.MsgBean;
import com.penchat.ui.activity.SearchActivity;
import com.penchat.ui.adapter.MsgListAdapter;
import com.penchat.ui.base.BaseFragment;
import com.penoder.mylibrary.adapter.CommonFragmentAdapter;
import com.penoder.mylibrary.dataBindinig.command.BindingCommand;
import com.penchat.R;
import com.penchat.databinding.FragmentMessageBinding;

import java.util.ArrayList;
import java.util.List;

import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;

public class MessageFragment extends BaseFragment<FragmentMessageBinding> {

    private MsgListAdapter msgAdapter;
    private List<MsgBean> msgBeanList = new ArrayList<>();

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_message;
    }

    @SuppressLint("InflateParams")
    @Override
    public void initView() {
        super.initView();
        ConversationListFragment listFragment = new ConversationListFragment();
        getBinding().viewPagerMsg.setAdapter(new CommonFragmentAdapter(getChildFragmentManager(), listFragment));
    }

    @Override
    public void initData() {
        super.initData();

    }

    private Uri getUrl() {
        return Uri.parse("rong://" + PenApplication.getInstance().getPackageName()).buildUpon()
                .appendPath("conversationList")
                .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false")
                .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "true")
                .appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName(), "false")
                .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "false")
                .build();
    }

    /**
     * 标题栏右上角 + 点击事件
     */
    public BindingCommand onAddCommand = new BindingCommand(() -> {

    });

    public BindingCommand onSearchCommand = new BindingCommand(() -> {
        if (isFastClick()) {
            return;
        }
        startActivity(new Intent(mContext, SearchActivity.class));
    });

    /**
     * 刷新事件
     */
    public BindingCommand onRefreshCommand = new BindingCommand(() -> {
        //
        getBinding().refreshMsgList.finishRefresh();
    });

    /**
     * 加载事件
     */
    public BindingCommand onLoadingCommand = new BindingCommand(() -> {
        //
        getBinding().refreshMsgList.finishLoadmore();
    });
}
