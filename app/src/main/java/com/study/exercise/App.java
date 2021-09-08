package com.study.exercise;

import android.app.Application;
import android.content.Context;

/**
 * Exercise
 * name: App
 * time: 2021/8/30 15:46.
 * author: 王益德
 * Describe:
 */
public class App extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
