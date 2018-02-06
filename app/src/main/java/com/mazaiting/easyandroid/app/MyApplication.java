package com.mazaiting.easyandroid.app;

import com.mazaiting.easy.app.app.BaseApplication;
import com.mazaiting.easy.config.BaseConfig;
import com.mazaiting.easyandroid.component.DaggerApplicationComponentImpl;
import com.mazaiting.easyandroid.config.Config;
import com.mazaiting.easyandroid.module.ApplicationModule;
import com.mazaiting.easyandroid.module.NetModule;

/**
 * 全局的Application
 * @author mazaiting
 * @date 2018/2/5
 */

public class MyApplication extends BaseApplication {
    /**
     * 自定义配置
     * @return
     */
    @Override
    protected BaseConfig setConfig() {
        return new Config();
    }

    /**
     * 初始化Application
     * @return
     */
    @Override
    protected BaseApplication initApp() {
        return this;
    }

    /**
     * 本项目使用Dagger2, 重写ApplicationComponent
     */
    @Override
    protected void initApplicationComponent() {
        // 设置 mApplicationComponent对象
        mApplicationComponent = DaggerApplicationComponentImpl.builder()
                .applicationModule(new ApplicationModule(sBaseApplication))
                .netModule(new NetModule())
                .build();
    }
}
