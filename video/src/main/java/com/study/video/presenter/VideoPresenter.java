package com.study.video.presenter;

import com.study.mvp_lib.presenter.BasePresenter;
import com.study.video.contract.IContract;
import com.study.video.entity.VideoEntity;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Exercise
 * name: VideoPresenter
 * time: 2021/9/1 14:43.
 * author: 王益德
 * Describe:
 */
public class VideoPresenter extends BasePresenter<IContract.IVideoView, IContract.IVideoModel> {

    @Inject
    public VideoPresenter(IContract.IVideoView view, IContract.IVideoModel model) {
        super(view, model);
    }

    public void getData(){
        model.getData(new Observer<VideoEntity>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull VideoEntity videoEntity) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
