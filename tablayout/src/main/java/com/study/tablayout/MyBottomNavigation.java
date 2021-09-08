package com.study.tablayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise
 * name: MyBottomNavigation
 * time: 2021/8/30 20:17.
 * author: 王益德
 * Describe:
 */
public class MyBottomNavigation extends FrameLayout implements View.OnClickListener {
    private static final String TAG = "MyBottomNavigation";
    private List<MyBottomItem> list;
    private List<View> viewList;
    private LinearLayout.LayoutParams layoutParams;

    private FrameLayout frameLayout;
    private LinearLayout linearLayout;

    public MyBottomNavigation(@NonNull Context context) {
        super(context);
        init();
    }

    public MyBottomNavigation(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 初始化方法
     */
    private void init() {
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));

        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bar_layout, this, true);

        frameLayout = inflate.findViewById(R.id.container);
        frameLayout.setBackgroundColor(Color.GRAY);

        linearLayout = findViewById(R.id.ll_container);

        //设置xml属性
        layoutParams = new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.weight = 1;

        list = new ArrayList<>();
        viewList = new ArrayList<>();
    }

//    @SuppressLint("DrawAllocation")
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(widthMeasureSpec,heightMeasureSpec));
//        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(widthMeasureSpec,heightMeasureSpec));
//    }

    /**
     * 对外提供（添加item）
     * @param item
     * @return
     */
    public MyBottomNavigation addItem(MyBottomItem item){
        list.add(item);
        return this;
    }

    /**
     * 对外提供（设置背景颜色）
     * @param color
     * @return
     */
    public MyBottomNavigation setBackColor(@ColorInt int color){
        frameLayout.setBackgroundColor(color);
        return this;
    }

    /**
     * 对外提供（设置选中字体颜色）
     * @param color
     * @return
     */
    public MyBottomNavigation setSelected(@ColorInt int color){
        return this;
    }

    /**
     * 设置选中字体颜色为白色
     * @param position
     */
    private void setSelectTextColor(int position) {
        for (int i = 0; i < viewList.size(); i++) {
            View view = viewList.get(i);
            if (view instanceof TextView){
                if (position == i){
                    ((TextView) view).setTextColor(Color.WHITE);
                    ((TextView) view).setTextSize(18);
                    ((TextView) view).setTypeface(Typeface.DEFAULT);
                }else {
                    ((TextView) view).setTextColor(getResources().getColor(R.color.unselectTextColor));
                    ((TextView) view).setTextSize(16);
                }
            }
        }
    }



    /**
     * 对外提供
     * 构造方法 将list中的值转化为view并添加到视图中
     */
    public void build(){
        for (int i = 0; i < list.size(); i++) {
            MyBottomItem myBottomItem = list.get(i);
            if (myBottomItem.getTitle()!=null){
                TextView textView = new TextView(getContext());
                textView.setText(myBottomItem.getTitle());
                textView.setGravity(Gravity.CENTER);
                textView.setLayoutParams(layoutParams);
                textView.setTag(R.id.itemClick,i);
                textView.setTextColor(getResources().getColor(R.color.unselectTextColor));
                textView.setTextSize(16);
                textView.setOnClickListener(this);
                linearLayout.addView(textView);
                viewList.add(textView);
            }

            if (myBottomItem.getDrawable()!=null){
                ImageView imageView = new ImageView(getContext());
                imageView.setImageDrawable(myBottomItem.getDrawable());
                imageView.setLayoutParams(layoutParams);
                imageView.setOnClickListener(this);
                imageView.setTag(R.id.itemClick,i);
                linearLayout.addView(imageView);
                viewList.add(imageView);
            }
        }
        setSelectTextColor(0);
    }


    /**
     * TextView和ImageView的点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        int i = (int) v.getTag(R.id.itemClick);

        listener.onSelected(i);

        setSelectTextColor(i);
    }

    //内部接口对象
    private MyItemClickListener listener;

    //内部接口（用于监听点击事件）
    public interface MyItemClickListener{
        void onSelected(int position);
    }

    //用于设置监听事件
    public void setMyListener(MyItemClickListener clickListener){
        this.listener = clickListener;
    }
}
