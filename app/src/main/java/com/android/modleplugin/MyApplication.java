package com.android.modleplugin;

import android.app.Application;

import com.android.basic.base.BaseContext;
import com.android.basic.base.IModuleManager;
import com.android.basic.base.ModleManager;
import com.android.floatview.floatview.modle.IModleFloatPluginImpl;
import com.android.modlea.modle.IModleAPluginImpl;
import com.android.modleb.modle.IModleBPluginImpl;
import com.android.modleinterface.IAudioPlayerPlugin;
import com.android.modleinterface.IModleAPlugin;
import com.android.modleinterface.IModleBPlugin;
import com.android.modleinterface.IModleFloatPlugin;
import com.pingan.audioplayer.modle.IAudioPlayerPluginImpl;

public class MyApplication extends Application {
    public static int index=0;
    @Override
    public void onCreate() {
        super.onCreate();
        initializeModule(this);
        registerActivityLifecycleCallbacks(new PActivityLifecycleCallbacks());

    }

    /**
     * 加载模块
     * @param application
     */
    public void initializeModule(Application application) {
        try {
            BaseContext.baseOn(new ModleManager(),application);
            IModuleManager moduleManager = BaseContext.getInstance().getModuleManager();
            if(moduleManager!=null) {
                moduleManager.registerModule(IAudioPlayerPlugin.TAG, IAudioPlayerPluginImpl.class);
                moduleManager.registerModule(IModleAPlugin.TAG, IModleAPluginImpl.class);
                moduleManager.registerModule(IModleBPlugin.TAG, IModleBPluginImpl.class);
                moduleManager.registerModule(IModleFloatPlugin.TAG, IModleFloatPluginImpl.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
