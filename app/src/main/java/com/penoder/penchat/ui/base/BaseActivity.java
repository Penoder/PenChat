package com.penoder.penchat.ui.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.penoder.mylibrary.utils.ToastUtil;
import com.penoder.penchat.BR;

/**
 * @author Penoder
 * @date 18-4-22.
 */
public abstract class BaseActivity<V extends ViewDataBinding> extends AppCompatActivity {

    private V binding;
    protected Context mContext;

    private long lastClickTime = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        binding = DataBindingUtil.setContentView(this, getLayoutID());
        IViewModel viewModel = createViewModel();
        binding.setVariable(BR.viewModel, viewModel != null ? viewModel : this);
        initData();
    }

    protected V getBinding() {
        return binding;
    }

    protected abstract int getLayoutID();

    private void initView() {

    }

    public void initData() {
        initView();
    }

    protected IViewModel createViewModel() {
        return null;
    }

    @Override
    protected void onDestroy() {
        ToastUtil.cancelToast();
        super.onDestroy();
    }

    private boolean isFastClick() {
        return isFastClick(500);
    }

    /**
     * 避免快速点击
     *
     * @param ms 两次点击之间需要的时间差
     * @return if return true, isFastClick, can't allow to click
     */
    private boolean isFastClick(int ms) {
        if (System.currentTimeMillis() - lastClickTime < ms) {
            return true;
        }
        lastClickTime = System.currentTimeMillis();
        return false;
    }
}
