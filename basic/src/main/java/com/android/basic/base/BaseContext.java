package com.android.basic.base;

import android.app.Application;

public class BaseContext {
    private static volatile BaseContext instance = null;
    private static Application sApp = null;
    private static IModuleManager mModuleManager = null;

    private BaseContext() {
    }

    public static BaseContext getInstance() {
        if (instance == null) {
            synchronized (BaseContext.class) {
                if (instance == null) {
                    instance = new BaseContext();
                }
            }
        }
        return instance;
    }
    /**
     * 必须先调用
     * @param moduleManager
     * @param app
     */
    public static void baseOn(IModuleManager moduleManager, Application app) {
        sApp = app;
        mModuleManager = moduleManager;
    }
    public BaseModule getModule(String tag) {
        return mModuleManager.getModule(tag);
    }
    public IModuleManager getModuleManager() {
        return mModuleManager;
    }

    public Application getApplication() {
        return sApp;
    }

}
