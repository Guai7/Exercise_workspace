package com.study.video;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.study.mvp_lib.presenter.IPresenter;
import com.study.mvp_lib.view.BaseActivity;
import com.study.video.contract.IContract;
import com.study.video.dagger.DaggerComponent;
import com.study.video.dagger.DaggerDaggerComponent;
import com.study.video.dagger.DaggerModel;
import com.study.video.presenter.VideoPresenter;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<VideoPresenter> implements IContract.IVideoView {



    @Override
    public void initView() {
        DaggerDaggerComponent.builder().daggerModel(new DaggerModel(this)).build().getPresenter(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }
}