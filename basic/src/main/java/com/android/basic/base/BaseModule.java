package com.android.basic.base;

import androidx.annotation.Nullable;

public abstract class BaseModule {
    @Nullable
    public static <T extends BaseModule> T getModule(String tag) {
        BaseModule module = BaseContext.getInstance().getModule(tag);
        if (module != null) {
            return (T) module;
        }
        return null;
    }
}
