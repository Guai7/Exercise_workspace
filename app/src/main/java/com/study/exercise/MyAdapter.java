package com.study.exercise;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Exercise
 * name: MyAdapter
 * time: 2021/8/30 16:16.
 * author: 王益德
 * Describe:
 */
public class MyAdapter extends BaseQuickAdapter<Search, BaseViewHolder> {

    public MyAdapter(int layoutResId, @Nullable List<Search> data) {
        super(layoutResId, data);
        addChildClickViewIds(R.id.del_img);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, Search search) {
        baseViewHolder.setText(R.id.name,search.getName());
    }
}
