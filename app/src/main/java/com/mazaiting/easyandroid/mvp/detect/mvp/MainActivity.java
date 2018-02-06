package com.mazaiting.easyandroid.mvp.detect.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mazaiting.easy.app.activity.BaseActivity;
import com.mazaiting.easy.app.app.ApplicationComponent;
import com.mazaiting.easyandroid.R;
import com.mazaiting.easyandroid.component.ApplicationComponentImpl;
import com.mazaiting.easyandroid.mvp.DaggerDetectComponent;
import com.mazaiting.easyandroid.mvp.detect.bean.DetectBean;
import com.mazaiting.easyandroid.mvp.detect.mvp.DetectContract;
import com.mazaiting.easyandroid.mvp.detect.mvp.DetectPresenter;
import com.orhanobut.logger.Logger;

import butterknife.BindView;

/**
 * 主界面
 * @author mazaiting
 * @date 2018/2/6
 */
public class MainActivity extends BaseActivity<DetectPresenter> implements DetectContract.View {
    /**TextView 显示返回结果*/
    @BindView(R.id.textView) TextView mTextView;

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
    public void bindView(View view, Bundle savedInstanceState) {
        mTextView.setText("测试");
    }

    @Override
    public void initData() {
        mPresenter.loadData();
    }

    @Override
    public void loadData(DetectBean detectBean) {
        mTextView.setText(detectBean.toString());
    }

    @Override
    public void onShowLoading() {

    }

    @Override
    public void onShowSuccess() {

    }

    @Override
    public void onShowFailed(String message) {
        Logger.e(message);
        // 设置失败信息
        mTextView.setText(message);
    }

    @Override
    public void onShowNoNet() {

    }

    @Override
    public void onRetry() {

    }

}
