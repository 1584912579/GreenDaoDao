package com.example.asus.greendaodao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.com.sky.downloader.greendao.DaoSession;
import com.com.sky.downloader.greendao.UserDao;
import com.example.asus.greendaodao.bean.User;
import com.example.asus.greendaodao.utils.MyApp;

import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 增
     */
    private Button mBtInsert;
    /**
     * 删
     */
    private Button mBtDel;
    /**
     * 改
     */
    private Button mBtUpdate;
    /**
     * 查
     */
    private Button mBtSelect;
    private DaoSession daoSession;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        daoSession = MyApp.getDaoSession();
        userDao = daoSession.getUserDao();

    }

    private void initView() {
        mBtInsert = (Button) findViewById(R.id.btInsert);
        mBtInsert.setOnClickListener(this);
        mBtDel = (Button) findViewById(R.id.btDel);
        mBtDel.setOnClickListener(this);
        mBtUpdate = (Button) findViewById(R.id.btUpdate);
        mBtUpdate.setOnClickListener(this);
        mBtSelect = (Button) findViewById(R.id.btSelect);
        mBtSelect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btInsert:
                for (int i = 1; i <= 10; i++) {
                    User user = new User();
                    user.setName("name_" + i);
                    user.setAge("age_" + i);
                    userDao.insert(user);
                }
                break;
            case R.id.btDel:

                User user = new User();
                user.setId(1L);
                user.setName("name_1");
                user.setAge("age_1");

//                userDao.delete(user);
                userDao.deleteByKey(2L);

                break;
            case R.id.btUpdate:
                User user1 = new User();
                user1.setId(1L);
                user1.setName("八维");
                user1.setAge("21");
                userDao.update(user1);
                break;
            case R.id.btSelect:
                select3();
                break;
        }
    }

    private void select3(){
        List<User> list = userDao.queryBuilder().orderDesc(UserDao.Properties.Id).build().list();
        for (int i = 0; i < list.size(); i++) {
            Log.e("MainActivity", list.get(i).toString());
        }
    }

    private void select2() {
        List<User> list = userDao.queryBuilder().where(UserDao.Properties.Id.eq("3")).build().list();
        for (int i = 0; i < list.size(); i++) {
            Log.e("MainActivity", list.get(i).toString());
        }
    }

    private void select1() {
        List<User> list = userDao.queryBuilder().build().list();
        for (int i = 0; i < list.size(); i++) {
            Log.e("MainActivity", list.get(i).toString());
        }
    }
}
