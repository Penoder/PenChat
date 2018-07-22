package com.penchat.ui.activity;

import android.databinding.ObservableBoolean;

import com.penchat.R;
import com.penchat.databinding.ActivityMainTabBinding;
import com.penchat.ui.base.BaseActivity;
import com.penchat.ui.fragment.ContactFragment;
import com.penchat.ui.fragment.DynamicFragment;
import com.penchat.ui.fragment.MessageFragment;
import com.penchat.ui.fragment.MineFragment;
import com.penoder.mylibrary.adapter.CommonFragmentAdapter;
import com.penoder.mylibrary.dataBindinig.command.BindingCommand;

public class MainTabActivity extends BaseActivity<ActivityMainTabBinding> {

    public final ObservableBoolean isMessageSelected = new ObservableBoolean(true);
    public final ObservableBoolean isContactSelected = new ObservableBoolean(false);
    public final ObservableBoolean isDynamicSelected = new ObservableBoolean(false);
    public final ObservableBoolean isCenterSelected = new ObservableBoolean(false);

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main_tab;
    }

    @Override
    public void initData() {
        super.initData();
        MessageFragment messageFragment = new MessageFragment();
        ContactFragment contactFragment = new ContactFragment();
        DynamicFragment dynamicFragment = new DynamicFragment();
        MineFragment minFragment = new MineFragment();
        getBinding().viewPagerMain.setAdapter(new CommonFragmentAdapter(getSupportFragmentManager(),
                messageFragment, contactFragment, dynamicFragment, minFragment));
        getBinding().viewPagerMain.setCurrentItem(0);
        getBinding().viewPagerMain.setPagingEnabled(true);
        getBinding().viewPagerMain.setOffscreenPageLimit(4);
    }

    public BindingCommand onMessageCommand = new BindingCommand(() -> {
        selectionTab(0);
        getBinding().viewPagerMain.setCurrentItem(0, false);
    });

    public BindingCommand onContactCommand = new BindingCommand(() -> {
        selectionTab(1);
        getBinding().viewPagerMain.setCurrentItem(1, false);
    });

    public BindingCommand onDynamicCommand = new BindingCommand(() -> {
        selectionTab(2);
        getBinding().viewPagerMain.setCurrentItem(2, false);
    });

    public BindingCommand onCenterCommand = new BindingCommand(() -> {
        selectionTab(3);
        getBinding().viewPagerMain.setCurrentItem(3, false);
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
