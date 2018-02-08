package com.mazaiting.easyandroid.module;

import android.content.Context;

import com.mazaiting.easy.app.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Application Module
 * 提供Application实例
 * @author mazaiting
 * @date 2018/2/5
 */
@Module
public class ApplicationModule {
    /**上下文*/
    private Context mContext;

    public ApplicationModule(Context context) {
        this.mContext = context;
    }

    /**
     * 提供 Application
     * @return BaseApplication
     */
    @Provides
    BaseApplication providedApplication() {
        return (BaseApplication) mContext.getApplicationContext();
    }

    /**
     * 提供 上下文
     * @return 上下文
     */
    @Provides @Singleton
    Context providedContext() {
        return mContext;
    }
}
