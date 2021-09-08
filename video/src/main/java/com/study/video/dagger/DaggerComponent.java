package com.study.video.dagger;

import androidx.appcompat.app.AppCompatActivity;

import com.study.video.MainActivity;

import dagger.Component;

/**
 * Exercise
 * name: DaggerComponent
 * time: 2021/9/1 14:38.
 * author: 王益德
 * Describe:
 */
@Component(modules = DaggerModel.class)
public interface DaggerComponent {
    void getPresenter(AppCompatActivity activity);
}
