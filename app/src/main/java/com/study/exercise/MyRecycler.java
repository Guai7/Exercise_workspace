package com.study.exercise;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Exercise
 * name: MyRecycler
 * time: 2021/8/30 15:49.
 * author: 王益德
 * Describe:
 */
public class MyRecycler extends RecyclerView {

    private boolean isFull = false;

    public MyRecycler(@NonNull Context context) {
        super(context);
    }

    public MyRecycler(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);

        if (isFull) {
            //展开状态
            int i = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
            super.onMeasure(widthSpec,i);
        }else {
            //未展开状态
            setMeasuredDimension(widthSpec,160);
        }
    }

    public boolean isFull(){
        return isFull;
    }

    public void setFull(boolean full){
        isFull = full;
        //刷新布局（重新调用onMeasure，onDraw,onLayout）
        requestLayout();
    }

}
