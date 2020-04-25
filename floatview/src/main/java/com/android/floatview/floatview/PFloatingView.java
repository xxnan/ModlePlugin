package com.android.floatview.floatview;

import android.content.Context;
import android.widget.ImageView;

import com.android.floatview.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

public class PFloatingView extends BaseFloatingView {

    private final ImageView mIcon;
    private int defResId;

    public PFloatingView(@NonNull Context context) {
        this(context, R.layout.float_layout);
    }

    public PFloatingView(@NonNull Context context, @LayoutRes int resource) {
        super(context, null);
        inflate(context, resource, this);
        mIcon = findViewById(R.id.icon);
    }

    public void setDefIconResId(int defResId) {
        this.defResId = defResId;
    }

    public void setIconImage(@DrawableRes int resId){
        mIcon.setImageResource(resId);
    }

    public void setIconImage(String imageUrl){
        Glide.with(getContext().getApplicationContext())
                .load(imageUrl)
                .apply(new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(defResId)
                        .error(defResId))
                .into(mIcon);
    }

}
