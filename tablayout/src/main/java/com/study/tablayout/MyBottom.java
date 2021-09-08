package com.study.tablayout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise
 * name: MyBottom
 * time: 2021/8/31 15:51.
 * author: 王益德
 * Describe:
 */
public class MyBottom extends FrameLayout {

    List<View> viewList;
    List<MyBottomItem> list;
    private LinearLayout linearLayout;
    private FrameLayout frameLayout;
    private LinearLayout.LayoutParams layoutParams;
    private LinearLayout.LayoutParams childLayoutParams;

    public MyBottom(@NonNull Context context) {
        super(context);
        init();
    }

    public MyBottom(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 初始化视图
     */
    private void init() {
        setLayoutParams(new ViewGroup.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)));

        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bar_layout, this, true);
        linearLayout = inflate.findViewById(R.id.ll_container);
        frameLayout = inflate.findViewById(R.id.container);

        frameLayout.setBackgroundColor(Color.GRAY);

        layoutParams = new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.weight = 1;
        layoutParams.gravity = Gravity.CENTER;


        childLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
        childLayoutParams.gravity = Gravity.CENTER;
        childLayoutParams.weight = 1;

        viewList = new ArrayList<>();
        list = new ArrayList<>();
    }
    
    //默认设置选中字体为白色
    private void setInitSelectedTextColor(int position){
        for (int i = 0; i < viewList.size(); i++) {
            View view = viewList.get(i);
            if (view instanceof TextView){
                if (position == i){
                    ((TextView) view).setTextSize(18);
                    ((TextView) view).setTextColor(Color.WHITE);
                }else {
                    ((TextView) view).setTextColor(getResources().getColor(R.color.unselectTextColor));
                    ((TextView) view).setTextSize(16);
                }
            }
        }
    }
    
    public void build(){
        for (int i = 0; i < list.size(); i++) {
            MyBottomItem myBottomItem = list.get(i);

            String title = myBottomItem.getTitle();
            Drawable drawable = myBottomItem.getDrawable();

            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setLayoutParams(layoutParams);
//            linearLayout.setOrientation(GradientDrawable);

            if (drawable!=null){
                ImageView imageView = new ImageView(getContext());
                imageView.setImageDrawable(drawable);
                imageView.setLayoutParams(layoutParams);

            }

            if (title!=null){
                TextView textView = new TextView(getContext());
                textView.setText(title);
                textView.setLayoutParams(layoutParams);
                textView.setTag(R.id.itemClick,i);

                linearLayout.addView(textView);


            }



//            viewList.add(textView);
//            this.linearLayout.addView(textView);
        }
    }



}
