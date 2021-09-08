package com.study.exercise;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Exercise
 * name: Search
 * time: 2021/8/30 15:43.
 * author: 王益德
 * Describe:
 */
@Entity
public class Search {
    @Id(autoincrement = true)
    private Long id;

    private String name;

    @Generated(hash = 648896676)
    public Search(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 1644193961)
    public Search() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
