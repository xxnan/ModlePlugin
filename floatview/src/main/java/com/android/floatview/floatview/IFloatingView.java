package com.android.floatview.floatview;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;

/**
 * Created by Yunpeng Li on 2018/3/15.
 */

public interface IFloatingView {

    FloatingViewManager remove();

    FloatingViewManager add();

    FloatingViewManager attach(Activity activity);

    FloatingViewManager attach(FrameLayout container);

    FloatingViewManager detach(Activity activity);

    FloatingViewManager detach(FrameLayout container);

    BaseFloatingView getView();

    FloatingViewManager icon(@DrawableRes int resId);

    FloatingViewManager customView(BaseFloatingView viewGroup);

    FloatingViewManager customView(@LayoutRes int resource);

    FloatingViewManager layoutParams(ViewGroup.LayoutParams params);

}
