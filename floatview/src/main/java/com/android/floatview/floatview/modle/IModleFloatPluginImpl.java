package com.android.floatview.floatview.modle;

import android.app.Activity;
import com.android.basic.base.BaseModule;
import com.android.floatview.floatview.FloatingViewManager;
import com.android.modleinterface.IModleFloatPlugin;

public class IModleFloatPluginImpl extends BaseModule implements IModleFloatPlugin {


    @Override
    public void attach(Activity activity) {
        FloatingViewManager.get().attach(activity);
    }

    @Override
    public void detach(Activity activity) {
        FloatingViewManager.get().detach(activity);
    }
}
