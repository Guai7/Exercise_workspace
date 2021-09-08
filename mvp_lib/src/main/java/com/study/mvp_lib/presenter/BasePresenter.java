package com.study.mvp_lib.presenter;

import com.study.mvp_lib.model.IModel;
import com.study.mvp_lib.view.IView;

import javax.inject.Inject;

/**
 * Exercise
 * name: BasePresenter
 * time: 2021/9/1 13:44.
 * author: 王益德
 * Describe:
 */
public class BasePresenter<V extends IView,M extends IModel > implements IPresenter {

    protected V view;
    protected M model;

    @Inject
    public BasePresenter(V view, M model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void destroy() {
        if (model != null) {
            model.destroy();
            model = null;
        }
    }
}
