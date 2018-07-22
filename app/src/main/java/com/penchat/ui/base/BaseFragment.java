package com.penchat.ui.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.penchat.BR;

/**
 * @author Penoder
 * @date 18-4-22.
 */
public abstract class BaseFragment<V extends ViewDataBinding> extends Fragment {

    private V binding;
    protected Context mContext;
    private long lastClickTime = -1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutID(), container, false);
        binding.executePendingBindings();
        IViewModel viewModel = createViewModel();
        binding.setVariable(BR.viewModel, viewModel == null ? this : viewModel);

        return binding.getRoot();
    }

    protected V getBinding() {
        return binding;
    }

    private IViewModel createViewModel() {
        return null;
    }

    protected abstract int getLayoutID();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    public void initView() {
    }

    public void initData() {
    }

    protected boolean isFastClick() {
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