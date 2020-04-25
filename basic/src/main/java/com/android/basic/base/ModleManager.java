package com.android.basic.base;

import android.text.TextUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * 模块管理
 */
public class ModleManager implements IModuleManager {
    /**
     * 预加载模块
     */
    private Map<String, Class> mModuleLoadClassMap = new ConcurrentHashMap<>();
    /**
     * 正常时间加载的模块
     */
    private Map<String, BaseModule> mModuleMap = new ConcurrentHashMap<>();

    @Override
    public boolean hasLoadModule(String tag) {
        return mModuleLoadClassMap.containsKey(tag);
    }

    @Override
    public BaseModule getModule(String tag) {
        if (TextUtils.isEmpty(tag)) {
            return null;
        }

        return findModuleInMap(tag);
    }

    @Override
    public boolean registerModule(String tag, Class<?> moduleImplCls) {
        if (TextUtils.isEmpty(tag) || moduleImplCls == null) {
            return false;
        }

        mModuleLoadClassMap.put(tag, moduleImplCls);

        return findModuleInMap(tag) != null;
    }

    private void preLoads() {
        try {
            for (Map.Entry<String, Class> entry : mModuleLoadClassMap.entrySet()) {
                getModule(entry.getKey());
//                loadModuleByTag(entry.getKey());
            }
        } catch (Exception e) {
        }
    }

    private BaseModule loadModuleByTag(String tag) throws Exception {
        return loadModuleByTag(tag, true);
    }

    /**
     * gen
     * @param tag
     * @param preLoad
     * @return
     * @throws Exception
     */
    private synchronized BaseModule loadModuleByTag(String tag, boolean preLoad) throws Exception {
        Class clazz = mModuleLoadClassMap.get(tag);
        if (clazz == null) {
            throw new Exception("can not find impl class for tag:" + tag);
        }
        try {
            BaseModule module = (BaseModule) clazz.newInstance();
            mModuleMap.put(tag, module);
            return module;
        } catch (Throwable e) {
            throw new Exception("can not load class:" + clazz.getName() + " for tag:" + tag);
        }
    }

    private synchronized BaseModule findModuleInMap(String tag) {
        BaseModule mod = mModuleMap.get(tag);
        if (mod == null) {
            try {
                BaseModule module = loadModuleByTag(tag, false);
                mod = module;
            } catch (Exception t) {
                mod = null;
            }
        }
        return mod;
    }
}
