package com.penoder.mylibrary.dataBindinig.viewadapter.swiperefresh;

import android.databinding.BindingAdapter;
import android.support.v4.widget.SwipeRefreshLayout;

import com.penoder.mylibrary.dataBindinig.command.BindingCommand;

/**
 * Created by goldze on 2017/6/18.
 */
public class ViewAdapter {
    @BindingAdapter({"onFlushCommand"})
    public static void onFlushCommand(SwipeRefreshLayout swipeRefreshLayout, final BindingCommand onFlushCommand) {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (onFlushCommand != null) {
                    onFlushCommand.execute();
                }
            }
        });
    }
}
