package com.mazaiting.easyandroid.config;

import com.mazaiting.easy.config.BaseConfig;

/**
 * 自定义控制
 * @author mazaiting
 * @date 2018/2/5
 */

public class Config extends BaseConfig {
    /**KEY*/
    public static final String API_KEY = "rv5Pab4EsmqWFft6tBKK5GqvsBGerHeb";
    /**密匙*/
    public static final String API_SECRET = "OVNhOVgsxOhq4wsYzSj7-88ZD1BO3vHP";
    /**URL公共的部分*/
    public static final String BASE_URL = "https://api-cn.faceplusplus.com/";

    @Override
    protected boolean isDebug() {
        return true;
    }

    @Override
    protected boolean isUseLeakCanary() {
        return true;
    }

    @Override
    public boolean isUseLogger() {
        return true;
    }

    @Override
    protected boolean isUseBlockCanary() {
        return false;
    }

    @Override
    protected boolean isUseStetho() {
        return true;
    }
}
