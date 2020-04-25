package com.android.modlea.modle;

import android.util.Log;

import com.android.basic.base.BaseModule;
import com.android.modleinterface.IModleAPlugin;

public class IModleAPluginImpl extends BaseModule implements IModleAPlugin{
    private String TAG="IModleAPluginImpl";
    @Override
    public void initModleA() {
        Log.d(TAG,"init modle A");
    }
}
