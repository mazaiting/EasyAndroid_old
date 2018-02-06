package com.mazaiting.easyandroid.mvp.detect.api;

import com.mazaiting.easyandroid.mvp.detect.bean.DetectBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * 检测API 服务
 * @author mazaiting
 * @date 2018/2/6
 */

public interface DetectApiService {
    /**
     * 检测
     * @param apiKey key
     * @param apiSecret secret
     * @param imageFile 图片
     * @return Observable
     */
    @Multipart @POST("facepp/v3/detect")
    Observable<DetectBean> detect(
            @Part MultipartBody.Part apiKey,
            @Part MultipartBody.Part apiSecret,
            @Part MultipartBody.Part imageFile
    );
}
