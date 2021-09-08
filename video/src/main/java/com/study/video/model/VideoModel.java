package com.study.video.model;

import com.study.mvp_lib.model.BaseModel;
import com.study.mvp_lib.model.IModel;
import com.study.video.Api;
import com.study.video.contract.IContract;
import com.study.video.entity.VideoEntity;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Exercise
 * name: VideoModel
 * time: 2021/9/1 14:32.
 * author: 王益德
 * Describe:
 */
public class VideoModel extends BaseModel implements IContract.IVideoModel {

    @Override
    public void getData(Observer<VideoEntity> observer) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(new OkHttpClient.Builder()
                        .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build())
                .build();
        retrofit.create(Api.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
