package com.android.basic.base;

public interface IModuleManager {
    String TAG = "ModuleManager";
    int RLT_OK = 0;

    BaseModule getModule(String tag);
    /**
     * 添加模块，并初始化模块
     * @param tag
     * @param moduleImplCls
     * @return
     */
    boolean registerModule(String tag, Class<?> moduleImplCls);
    boolean hasLoadModule(String tag);
}
