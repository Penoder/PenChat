package com.penoder.mylibrary.dataBindinig.viewadapter.view;

import android.annotation.SuppressLint;
import android.databinding.BindingAdapter;
import android.view.MotionEvent;
import android.view.View;

import com.jakewharton.rxbinding2.view.RxView;
import com.penoder.mylibrary.dataBindinig.command.BindingCommand;
import com.penoder.mylibrary.dataBindinig.command.ResponseCommand;

import io.reactivex.functions.Consumer;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

/**
 * Created by goldze on 2017/6/16.
 */

public class ViewAdapter {

    /**
     * View的onClick事件绑定
     */
    @SuppressLint("CheckResult")
    @BindingAdapter({"onClickCommand"})
    public static void onClickCommand(View view, final BindingCommand clickCommand) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickCommand != null) {
                    clickCommand.execute();
                }
            }
        });
    }

    /**
     * view的onLongClick事件绑定
     */
    @SuppressLint("CheckResult")
    @BindingAdapter({"onLongClickCommand"})
    public static void onLongClickCommand(View view, final BindingCommand clickCommand) {
        RxView.longClicks(view)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object object) throws Exception {
                        if (clickCommand != null) {
                            clickCommand.execute();
                        }
                    }
                });
    }

    /**
     * 回调控件本身
     */
    @BindingAdapter({"onViewCommand"})
    public static void onViewCommand(View view, BindingCommand clickCommand) {
        if (clickCommand != null) {
            clickCommand.execute(view);
        }
    }

    /**
     * view是否需要获取焦点
     */
    @BindingAdapter({"requestFocus"})
    public static void requestFocusCommand(View view, final Boolean needRequestFocus) {
        if (needRequestFocus) {
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        } else {
            view.clearFocus();
        }
    }

    /**
     * view的焦点发生变化的事件绑定
     */
    @BindingAdapter({"onFocusChangeCommand"})
    public static void onFocusChangeCommand(View view, final BindingCommand<Boolean> onFocusChangeCommand) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (onFocusChangeCommand != null) {
                    onFocusChangeCommand.execute(hasFocus);
                }
            }
        });
    }

    @BindingAdapter({"onTouchCommand"})
    public static void onTouchCommand(View view, final ResponseCommand<MotionEvent, Boolean> onTouchCommand) {
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (onTouchCommand != null) {
                    return onTouchCommand.execute(event);
                }
                return false;
            }
        });
    }

    @BindingAdapter({"isVisible"})
    public static void isVisible(View view, int visible) {
        if (visible == -1) {
            view.setVisibility(GONE);
        } else if (visible == 0) {
            view.setVisibility(VISIBLE);
        } else {
            view.setVisibility(INVISIBLE);
        }
    }

    @BindingAdapter({"isSelected"})
    public static void isSelected(View view, boolean selected) {
        view.setSelected(selected);
    }

    @BindingAdapter({"isClickable"})
    public static void isClickable(View view, boolean clickable) {
        view.setClickable(clickable);
    }

    @BindingAdapter({"isPressed"})
    public static void isPressed(View view, boolean pressed) {
        view.setPressed(pressed);
    }

}
