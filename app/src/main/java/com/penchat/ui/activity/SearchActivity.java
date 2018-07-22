package com.penchat.ui.activity;

import com.penchat.R;
import com.penchat.databinding.ActivitySearchBinding;
import com.penchat.ui.base.BaseActivity;
import com.penoder.mylibrary.dataBindinig.command.BindingCommand;

public class SearchActivity extends BaseActivity<ActivitySearchBinding> {
    @Override
    protected int getLayoutID() {
        return R.layout.activity_search;
    }

    public BindingCommand onCancelCommand = new BindingCommand(this::finish);
}
