package com.study.mvp_lib.view;

import android.view.View;

import androidx.annotation.IdRes;

/**
 * Exercise
 * name: IFragment
 * time: 2021/9/1 13:38.
 * author: ็็ๅพท
 * Describe:
 */
public interface IFragment extends IActivity {

    <T extends View> T findViewById(@IdRes int id);
}
