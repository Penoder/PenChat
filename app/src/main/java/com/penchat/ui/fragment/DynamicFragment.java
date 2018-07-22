package com.penchat.ui.fragment;

import com.penchat.R;
import com.penchat.databinding.FragmentDynamicBinding;
import com.penchat.ui.base.BaseFragment;

public class DynamicFragment extends BaseFragment<FragmentDynamicBinding> {
    @Override
    protected int getLayoutID() {
        return R.layout.fragment_dynamic;
    }
}
