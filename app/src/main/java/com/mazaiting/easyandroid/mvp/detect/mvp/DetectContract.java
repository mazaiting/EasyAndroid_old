package com.mazaiting.easyandroid.mvp.detect.mvp;

import com.mazaiting.easy.app.mvp.IBasePresenter;
import com.mazaiting.easy.app.mvp.IBaseView;
import com.mazaiting.easyandroid.mvp.detect.bean.DetectBean;

/**
 * 存放人脸检测View，Presenter
 * @author mazaiting
 * @date 2018/2/6
 */

public interface DetectContract {
    interface View extends IBaseView {
        /**
         * 加载数据
         * @param detectBean 人脸Java Bean
         */
        void loadData(DetectBean detectBean);
    }

    interface Presenter extends IBasePresenter<View> {
        /**
         * 加载数据
         */
        void loadData();
    }
}
