package com.android.modleplugin;

import android.app.Application;

import com.android.basic.base.BaseContext;
import com.android.basic.base.IModuleManager;
import com.android.basic.base.ModleManager;
import com.android.modleinterface.IAudioPlayerPlugin;
import com.android.modleinterface.IModleAPlugin;
import com.android.modleinterface.IModleBPlugin;
import com.android.modleinterface.IModleFloatPlugin;

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
                moduleManager.registerModule(IAudioPlayerPlugin.TAG, IAudioPlayerPlugin.class);
                moduleManager.registerModule(IModleAPlugin.TAG, IModleAPlugin.class);
                moduleManager.registerModule(IModleBPlugin.TAG, IModleBPlugin.class);
                moduleManager.registerModule(IModleFloatPlugin.TAG, IModleFloatPlugin.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
