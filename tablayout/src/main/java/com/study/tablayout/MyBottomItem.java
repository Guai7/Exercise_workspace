package com.study.tablayout;

import android.graphics.drawable.Drawable;

/**
 * Exercise
 * name: MyBottomItem
 * time: 2021/8/30 20:11.
 * author: 王益德
 * Describe:
 */
public class MyBottomItem {
    private String title;
    private Drawable drawable;



    public MyBottomItem() {
    }

    public MyBottomItem(String title, Drawable drawable) {
        this.title = title;
        this.drawable = drawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    @Override
    public String toString() {
        return "MyBottomItem{" +
                "title='" + title + '\'' +
                ", drawable=" + drawable +
                '}';
    }
}
