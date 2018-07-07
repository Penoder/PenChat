package com.penoder.mylibrary.dataBindinig.viewadapter.refreshview;

import android.databinding.BindingAdapter;

import com.penoder.mylibrary.dataBindinig.command.BindingCommand;
import com.penoder.mylibrary.refresh.PenoderRefreshLayout;
import com.penoder.mylibrary.refresh.api.RefreshLayout;
import com.penoder.mylibrary.refresh.listener.OnLoadmoreListener;
import com.penoder.mylibrary.refresh.listener.OnRefreshListener;

/**
 * @author Penoder
 * @date 18-3-24.
 */
public class ViewBindingAdapter {

    @BindingAdapter({"onRefreshCommand"})
    public static void onRefreshCommand(PenoderRefreshLayout refreshLayout, final BindingCommand onRefreshCommand) {
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                if (onRefreshCommand != null) {
                    onRefreshCommand.execute();
                }
            }
        });
    }

    @BindingAdapter({"onLoadingCommand"})
    public static void onLoadingCommand(PenoderRefreshLayout refreshLayout, final BindingCommand onLoadingCommand) {
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                if (onLoadingCommand != null) {
                    onLoadingCommand.execute();
                }
            }
        });
    }

}
