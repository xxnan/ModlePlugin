package com.android.modleinterface;

import android.app.Activity;

public interface IModleFloatPlugin {
    public static final String TAG="modleFloat";
    void attach(Activity activity);
    void detach(Activity activity);
}
