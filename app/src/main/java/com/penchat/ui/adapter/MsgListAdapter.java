package com.penchat.ui.adapter;

import android.content.Context;
import android.widget.TextView;

import com.penchat.R;
import com.penchat.entity.MsgBean;
import com.penoder.mylibrary.adapter.CommonRecycleAdapter;
import com.penoder.mylibrary.view.CircleImageView;

import java.util.List;

public class MsgListAdapter extends CommonRecycleAdapter<MsgBean> {

    private Context mContext;
    private List<MsgBean> msgList;

    public MsgListAdapter(Context context, List<MsgBean> datas) {
        super(datas, R.layout.item_message_list);
        this.mContext = context;
        this.msgList = datas;
    }

    @Override
    protected void onConvertView(MsgBean msgBean, ViewHolder holder, int position) {
        CircleImageView circleImgMsgHead = holder.getView(R.id.circleImg_msgHead);
        TextView txtViewMsgTime = holder.getView(R.id.txtView_msgTime);
        TextView txtViewMsgTitle = holder.getView(R.id.txtView_msgTitle);
        TextView txtViewMsgContent = holder.getView(R.id.txtView_msgContent);

    }
}
