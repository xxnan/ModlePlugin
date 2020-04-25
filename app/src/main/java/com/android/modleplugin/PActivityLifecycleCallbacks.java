package com.android.modleplugin;


import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;

import com.android.basic.base.BaseModule;
import com.android.modleinterface.IModleFloatPlugin;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class PActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        IModleFloatPlugin plugin=BaseModule.getModule(IModleFloatPlugin.TAG);
        plugin.attach(activity);
    }

    @Override
    public void onActivityPaused(Activity activity) {
        IModleFloatPlugin plugin=BaseModule.getModule(IModleFloatPlugin.TAG);
        plugin.detach(activity);
    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
    }
}
