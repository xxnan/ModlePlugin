package com.android.modleb.modle;
import android.util.Log;

import com.android.basic.base.BaseModule;
import com.android.modleinterface.IModleBPlugin;

public class IModleBPluginImpl extends BaseModule implements IModleBPlugin {
    public  String TAG="IModleBPluginImpl";

    @Override
    public void initModleB() {
        Log.d(TAG,"init modle B");
    }
}
