package com.mazaiting.easyandroid.mvp.detect.mvp;

import android.widget.TextView;

import com.mazaiting.easy.app.ApplicationComponent;
import com.mazaiting.easy.base.activity.BaseMultiStateActivity;
import com.mazaiting.easyandroid.R;
import com.mazaiting.easyandroid.component.ApplicationComponentImpl;
import com.mazaiting.easyandroid.mvp.detect.bean.DetectBean;
import com.mazaiting.easyandroid.mvp.detect.component.DaggerDetectComponent;
import com.orhanobut.logger.Logger;

/**
 * 主界面
 *
 * @author mazaiting
 * @date 2018/2/6
 */
public class MainActivity extends BaseMultiStateActivity<DetectPresenter> implements DetectContract.View {

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void inject(ApplicationComponent applicationComponent) {
        // 注入当前Activity
        DaggerDetectComponent.builder()
                .applicationComponentImpl((ApplicationComponentImpl) applicationComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initData() {
        mPresenter.loadData();
    }

    @Override
    public void loadData(DetectBean detectBean) {
        Logger.e("kldsjflksdj");
    }

    @Override
    public void onRetry() {
        mPresenter.loadData();
    }

    @Override
    public void onShowFailed(String message) {
        super.onShowFailed(message);
        Logger.e(message);
    }
}
