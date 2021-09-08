package com.study.exercise.utils;

import android.database.sqlite.SQLiteDatabase;

import com.study.exercise.App;
import com.study.exercise.db.DaoMaster;
import com.study.exercise.db.DaoSession;

/**
 * Exercise
 * name: DaoManager
 * time: 2021/8/30 15:44.
 * author: 王益德
 * Describe:
 */
public class DaoManager {
    private static DaoManager manager;
    private DaoSession daoSession;

    /**
     * 构造方法
     */
    private DaoManager() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(App.context,"search.db");
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        DaoMaster master = new DaoMaster(db);
        daoSession = master.newSession();
    }

    /**
     * 单例模式（双重锁）
     * @return
     */
    public static DaoManager getInstance() {
        if (manager == null) {
            synchronized (DaoManager.class){
                if (manager == null) {
                    manager = new DaoManager();
                }
            }
        }
        return manager;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
