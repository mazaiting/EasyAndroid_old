package com.mazaiting.easyandroid.module;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.mazaiting.easy.app.BaseApplication;
import com.mazaiting.easy.utils.NetUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络Module
 * 提供Retrofit示例
 * @author mazaiting
 * @date 2018/2/5
 */
@Module
public class NetModule {
    /**
     * 获取SharedPreferences存储对象
     * @param application 全局对象
     * @return SharedPreferences存储对象
     */
    @Provides @Singleton
    SharedPreferences providedSharedPreferences(BaseApplication application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    /**
     * 获取 Retrofit.Builder对象
     * @param application 全局量
     * @return Retrofit.Builder对象
     */
    @Provides
    Retrofit.Builder providedRetrofit(BaseApplication application) {
        return new Retrofit.Builder()
                // 添加Gson解析器
                .addConverterFactory(GsonConverterFactory.create())
                // 添加RxJava适配器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                // 设置OkHttpClient客户端
                .client(NetUtil.getOkHttpClientWithCache(application));
    }
}
