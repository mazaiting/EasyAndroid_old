package com.mazaiting.easyandroid.module;

import com.mazaiting.easyandroid.config.Config;
import com.mazaiting.easyandroid.mvp.detect.api.DetectApi;
import com.mazaiting.easyandroid.mvp.detect.api.DetectApiService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Api Module，此类中主要是提供Api
 * @author mazaiting
 * @date 2018/2/6
 */

@Module
public class ApiModule {

    @Provides
    DetectApi providedDetectApi(Retrofit.Builder builder) {
        return DetectApi.getInstance(
                builder.baseUrl(Config.BASE_URL)
                .build().create(DetectApiService.class)
        );
    }
}
