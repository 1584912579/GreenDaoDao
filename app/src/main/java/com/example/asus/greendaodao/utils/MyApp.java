package com.example.asus.greendaodao.utils;

import android.app.Application;

import com.com.sky.downloader.greendao.DaoMaster;
import com.com.sky.downloader.greendao.DaoSession;

/**
 * Created by asus on 2018/5/11.
 */

public class MyApp extends Application {
    private DaoMaster daoMaster;
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化GreenDao
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "user.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
