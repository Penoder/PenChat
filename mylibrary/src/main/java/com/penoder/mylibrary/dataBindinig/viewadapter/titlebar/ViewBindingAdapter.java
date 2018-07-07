package com.penoder.mylibrary.dataBindinig.viewadapter.titlebar;

import android.databinding.BindingAdapter;
import android.view.View;

import com.penoder.mylibrary.dataBindinig.command.BindingCommand;
import com.penoder.mylibrary.view.CustomTitle;

/**
 * @author Penoder
 * @date 18-4-19.
 */
public class ViewBindingAdapter {

    @BindingAdapter({"titleClickCommand", "titleDoubleClickCommand"})
    public static void titleCommand(CustomTitle titleView, final BindingCommand titleClickCommand, final BindingCommand titleDoubleClickCommand) {
        titleView.setOnTitleClickListener(new CustomTitle.OnTitleClickListener() {
            @Override
            public void onTitleClick(View view) {
                if (titleClickCommand != null) {
                    titleClickCommand.execute();
                }
            }

            @Override
            public void onTitleDoubleClick(View view) {
                if (titleDoubleClickCommand != null) {
                    titleDoubleClickCommand.execute();
                }
            }
        });
    }

    @BindingAdapter({"leftIconClickCommand"})
    public static void leftIconClickCommand(CustomTitle titleView, final BindingCommand leftIconClickCommand) {
        titleView.setOnLeftIconClickListener(view -> {
            if (leftIconClickCommand != null) {
                leftIconClickCommand.execute();
            }
        });
    }

    @BindingAdapter({"rightIconClickCommand"})
    public static void rightIconClickCommand(CustomTitle titleView, final BindingCommand rightIconClickCommand) {
        titleView.setOnRightIconClickListener(view -> {
            if (rightIconClickCommand != null) {
                rightIconClickCommand.execute();
            }
        });
    }

    @BindingAdapter({"rightTitleClickCommand"})
    public static void rightTitleClickCommand(CustomTitle titleView, final BindingCommand rightTitleClickCommand) {
        titleView.setOnRightTitleClickListener(view -> {
            if (rightTitleClickCommand != null) {
                rightTitleClickCommand.execute();
            }
        });
    }
}
