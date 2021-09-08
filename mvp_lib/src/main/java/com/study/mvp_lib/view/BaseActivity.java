package com.study.mvp_lib.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.study.mvp_lib.presenter.IPresenter;

import javax.inject.Inject;

/**
 * Exercise
 * name: BaseActivity
 * time: 2021/9/1 13:39.
 * author: 王益德
 * Describe:
 */
public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IView,IActivity {

    @Inject
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());

        initView();
        initData();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
