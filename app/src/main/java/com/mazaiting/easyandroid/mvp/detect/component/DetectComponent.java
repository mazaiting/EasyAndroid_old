package com.mazaiting.easyandroid.mvp.detect.component;

import com.mazaiting.easyandroid.mvp.detect.mvp.MainActivity;
import com.mazaiting.easyandroid.component.ApplicationComponentImpl;

import dagger.Component;

/**
 * 人脸检测组件
 * @author mazaiting
 * @date 2018/2/6
 */

@Component(dependencies = ApplicationComponentImpl.class)
public interface DetectComponent {
    /**
     * 注入activity
     * @param activity 界面
     */
    void inject(MainActivity activity);
}
