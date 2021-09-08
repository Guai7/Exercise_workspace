package com.study.video;

import com.study.video.entity.VideoEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Exercise
 * name: Api
 * time: 2021/9/1 14:34.
 * author: 王益德
 * Describe:
 */
public interface Api {
    @GET("")
    Observable<VideoEntity> getData();
}
