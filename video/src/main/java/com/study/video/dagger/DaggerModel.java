package com.study.video.dagger;

import com.study.video.contract.IContract;
import com.study.video.model.VideoModel;

import dagger.Module;
import dagger.Provides;

/**
 * Exercise
 * name: DaggerModel
 * time: 2021/9/1 14:38.
 * author: 王益德
 * Describe:
 */
@Module
public class DaggerModel {
    private IContract.IVideoView videoView;

    public DaggerModel(IContract.IVideoView videoView) {
        this.videoView = videoView;
    }

    @Provides
    public IContract.IVideoModel getVideoModel(){
        return new VideoModel();
    }

    @Provides
    public IContract.IVideoView getVideoView(){
        return videoView;
    }

}
