package com.penoder.mylibrary.dataBindinig.viewadapter.image;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.penoder.mylibrary.dataBindinig.command.BindingCommand;

/**
 * Created by goldze on 2017/6/18.
 */
public final class ViewAdapter {

    @BindingAdapter({"imgResource"})
    public static void setImgResource(ImageView imgView, int resId) {
        imgView.setImageResource(resId);
    }

    @BindingAdapter({"imgBgResource"})
    public static void setImgBgResource(ImageView imgView, int resId) {
        imgView.setBackgroundResource(resId);
    }

    @BindingAdapter(value = {"uri", "placeholderImageRes", "request_width", "request_height", "onSuccessCommand", "onFailureCommand"}, requireAll = false)
    public static void loadImage(
            final ImageView imageView, String uri, @DrawableRes int placeholderImageRes,
            int width, int height,
            final BindingCommand<GlideDrawable> onSuccessCommand,
            final BindingCommand<Target<GlideDrawable>> onFailureCommand) {
        if (!TextUtils.isEmpty(uri)) {
            RequestListener<String, GlideDrawable> requestListener = new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    if (onFailureCommand != null) {
                        onFailureCommand.execute(target);
                    }
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    if (onSuccessCommand != null) {
                        onSuccessCommand.execute(resource);
                    }
                    return false;
                }
            };

            if (width > 0 && height > 0) {
                Glide.with(imageView.getContext())
                        .load(uri)
                        .override(width, height)
                        .placeholder(placeholderImageRes)
                        .listener(requestListener)
                        .into(imageView);
            } else {
                Glide.with(imageView.getContext())
                        .load(uri)
                        .placeholder(placeholderImageRes)
                        .listener(requestListener)
                        .into(imageView);
            }
        } else {
            imageView.setImageResource(placeholderImageRes);
        }
    }
}

