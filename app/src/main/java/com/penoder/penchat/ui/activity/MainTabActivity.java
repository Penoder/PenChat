package com.penoder.penchat.ui.activity;

import android.databinding.ObservableBoolean;
import android.support.v4.app.Fragment;

import com.penoder.mylibrary.adapter.CommonFragmentAdapter;
import com.penoder.mylibrary.dataBindinig.command.BindingCommand;
import com.penoder.mylibrary.utils.ToastUtil;
import com.penoder.penchat.R;
import com.penoder.penchat.databinding.ActivityMainTabBinding;
import com.penoder.penchat.ui.base.BaseActivity;
import com.penoder.penchat.ui.fragment.ContactFragment;
import com.penoder.penchat.ui.fragment.DynamicFragment;
import com.penoder.penchat.ui.fragment.MessageFragment;
import com.penoder.penchat.ui.fragment.MineFragment;

public class MainTabActivity extends BaseActivity<ActivityMainTabBinding> {

    public final ObservableBoolean isMessageSelected = new ObservableBoolean(true);
    public final ObservableBoolean isContactSelected = new ObservableBoolean(false);
    public final ObservableBoolean isDynamicSelected = new ObservableBoolean(false);
    public final ObservableBoolean isCenterSelected = new ObservableBoolean(false);

    private Fragment messageFragment, contactFragment, dynamicFragment, minFragment;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main_tab;
    }

    @Override
    public void initData() {
        super.initData();
        messageFragment = new MessageFragment();
        contactFragment = new ContactFragment();
        dynamicFragment = new DynamicFragment();
        minFragment = new MineFragment();
        getBinding().viewPagerMain.setAdapter(new CommonFragmentAdapter(getSupportFragmentManager(),
                messageFragment, contactFragment, dynamicFragment, minFragment));
        getBinding().viewPagerMain.setCurrentItem(0);
        getBinding().viewPagerMain.setPagingEnabled(true);
        getBinding().viewPagerMain.setOffscreenPageLimit(4);
    }

    public BindingCommand onMessageCommand = new BindingCommand(() -> {
        selectionTab(0);
        getBinding().viewPagerMain.setCurrentItem(0, false);
        ToastUtil.showShortToast(mContext, R.string.message);
    });

    public BindingCommand onContactCommand = new BindingCommand(() -> {
        selectionTab(1);
        getBinding().viewPagerMain.setCurrentItem(1, false);
        ToastUtil.showShortToast(mContext, R.string.contact);
    });

    public BindingCommand onDynamicCommand = new BindingCommand(() -> {
        selectionTab(2);
        getBinding().viewPagerMain.setCurrentItem(2, false);
        ToastUtil.showShortToast(mContext, R.string.dynamic);
    });

    public BindingCommand onCenterCommand = new BindingCommand(() -> {
        selectionTab(3);
        getBinding().viewPagerMain.setCurrentItem(3, false);
        ToastUtil.showShortToast(mContext, R.string.mine);
    });

    public BindingCommand<Integer> onPagerSelectedCommand = new BindingCommand<>(this::selectionTab);

    private void selectionTab(int tab) {
        isMessageSelected.set(false);
        isContactSelected.set(false);
        isDynamicSelected.set(false);
        isCenterSelected.set(false);

        switch (tab) {
            case 0:
                isMessageSelected.set(true);
                break;
            case 1:
                isContactSelected.set(true);
                break;
            case 2:
                isDynamicSelected.set(true);
                break;
            case 3:
                isCenterSelected.set(true);
                break;
        }
    }
}
