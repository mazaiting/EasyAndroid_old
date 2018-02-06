package com.mazaiting.easyandroid.mvp.detect.mvp;

import com.mazaiting.easy.net.BaseObserver;
import com.mazaiting.easy.presenter.BasePresenter;
import com.mazaiting.easy.utils.RxScheduler;
import com.mazaiting.easyandroid.config.Config;
import com.mazaiting.easyandroid.mvp.detect.api.DetectApi;
import com.mazaiting.easyandroid.mvp.detect.bean.DetectBean;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * 人脸检测主持人
 * @author mazaiting
 * @date 2018/2/6
 */

public class DetectPresenter extends BasePresenter<DetectContract.View> implements DetectContract.Presenter{
    private DetectApi mDetectApi;
    @Inject
    DetectPresenter(DetectApi detectApi) {
        this.mDetectApi = detectApi;
    }

    @Override
    public void loadData() {
        // 创建统治者
        Observable<DetectBean> observable = mDetectApi.detect(Config.API_KEY, Config.API_SECRET, "sdcard/face/detect.png");
        // 调度线程
        observable.compose(RxScheduler.applySchedulers())
                // 绑定声明周期
                .compose(mView.bindToLife())
                // 通知
                .subscribe(new BaseObserver<DetectBean>() {
                    @Override
                    protected void onSuccess(DetectBean detectBean) {
                        mView.loadData(detectBean);
                    }

                    @Override
                    protected void onFailed(Throwable e) {
                        mView.onShowFailed(e.getMessage());
                    }
                });
    }
}
