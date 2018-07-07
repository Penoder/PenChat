package com.penoder.penchat.ui.fragment;

import com.penoder.penchat.R;
import com.penoder.penchat.databinding.FragmentDynamicBinding;
import com.penoder.penchat.ui.base.BaseFragment;

public class DynamicFragment extends BaseFragment<FragmentDynamicBinding> {
    @Override
    protected int getLayoutID() {
        return R.layout.fragment_dynamic;
    }
}
