package com.mazaiting.easyandroid.component;

import com.mazaiting.easy.app.app.ApplicationComponent;
import com.mazaiting.easyandroid.module.ApiModule;
import com.mazaiting.easyandroid.module.ApplicationModule;
import com.mazaiting.easyandroid.module.NetModule;
import com.mazaiting.easyandroid.mvp.detect.api.DetectApi;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * 全局ApplicationComponent组件
 * @author mazaiting
 * @date 2018/2/5
 */
@Component(modules = {NetModule.class, ApiModule.class, ApplicationModule.class})
public interface ApplicationComponentImpl extends ApplicationComponent{

    /**
     * 获取 Retrofit.Builder对象
     * @return Retrofit.Builder对象
     */
    Retrofit.Builder getRetrofitBuilder();

    /**
     * 获取 检测Api对象
     * @return 检测Api对象
     */
    DetectApi getDetectApi();
}
