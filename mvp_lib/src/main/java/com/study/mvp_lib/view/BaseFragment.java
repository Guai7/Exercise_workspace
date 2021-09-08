package com.study.mvp_lib.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.study.mvp_lib.presenter.IPresenter;

import javax.inject.Inject;

/**
 * Exercise
 * name: BaseFragment
 * time: 2021/9/1 13:41.
 * author: 王益德
 * Describe:
 */
public abstract class BaseFragment<P extends IPresenter> extends Fragment implements IView,IFragment {

    @Inject
    protected P presenter;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(bindLayout(),container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return view.findViewById(id);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
