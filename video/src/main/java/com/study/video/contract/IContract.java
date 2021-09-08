package com.study.video.contract;

import com.study.mvp_lib.model.IModel;
import com.study.mvp_lib.view.IView;
import com.study.video.entity.VideoEntity;

import java.util.List;

import io.reactivex.Observer;

/**
 * Exercise
 * name: IContract
 * time: 2021/9/1 14:30.
 * author: 王益德
 * Describe:
 */
public interface IContract {
    interface IVideoModel extends IModel{
        void getData(Observer<VideoEntity> observer);
    }

    interface IVideoView extends IView{

    }
}
