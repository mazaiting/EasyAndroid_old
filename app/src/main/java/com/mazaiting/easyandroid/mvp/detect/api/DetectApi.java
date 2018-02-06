package com.mazaiting.easyandroid.mvp.detect.api;

import com.mazaiting.easyandroid.mvp.detect.bean.DetectBean;

import java.io.File;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * 检测相关API
 * @author mazaiting
 * @date 2018/2/6
 */

public class DetectApi {
    private static DetectApi sInstance;
    /**检测Api 服务*/
    private DetectApiService mService;
    private DetectApi(DetectApiService newsApiService) {
        this.mService = newsApiService;
    }

    /**
     * 单例
     * @param detectApiService api 服务
     * @return DetectApi
     */
    public static DetectApi getInstance(DetectApiService detectApiService) {
        if (null == sInstance) {
            synchronized (DetectApi.class) {
                if (null == sInstance) {
                    sInstance = new DetectApi(detectApiService);
                }
            }
        }
        return sInstance;
    }

    /**
     * 人脸检测
     * @param key key
     * @param secret secret
     * @param filePath 图片文件
     * @return Observable
     */
    public Observable<DetectBean> detect(String key, String secret, String filePath) {
        MultipartBody.Part apiKey = MultipartBody.Part.createFormData("api_key", key);
        MultipartBody.Part apiSecret = MultipartBody.Part.createFormData("api_secret", secret);
        File file = new File(filePath);
        RequestBody requestBody = MultipartBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part imageFile = MultipartBody.Part.createFormData("image_file", file.getName(), requestBody);
        return mService.detect(apiKey, apiSecret, imageFile);
    }
}
