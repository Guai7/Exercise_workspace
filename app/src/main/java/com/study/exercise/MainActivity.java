package com.study.exercise;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.blankj.utilcode.util.NetworkUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.study.exercise.db.DaoSession;
import com.study.exercise.db.SearchDao;
import com.study.exercise.utils.DaoManager;

import org.greenrobot.greendao.query.QueryBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ScrollView scrollView;
    private LinearLayout ll;
    private EditText edit;
    private ImageView search;
    private TextView showAll;
    private MyRecycler myRecycler;
    private List<Search> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        //配置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        //设置布局管理器
        myRecycler.setLayoutManager(linearLayoutManager);

        //查询数据库
        SearchDao daoSession = DaoManager.getInstance().getDaoSession().getSearchDao();
        //以降序查询 10条数据
        List<Search> searchQueryBuilder = daoSession.queryBuilder().orderDesc(SearchDao.Properties.Id).limit(10).build().list();
        list.addAll(searchQueryBuilder);

        //适配数据
        MyAdapter myAdapter = new MyAdapter(R.layout.rv_layout,list);
        myRecycler.setAdapter(myAdapter);

        /*
        设置删除记录按钮
         */
        myAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onItemChildClick(@NonNull @NotNull BaseQuickAdapter adapter, @NonNull @NotNull View view, int position) {

                switch (view.getId()) {
                    case R.id.del_img:
                        //删除数据库此条数据
                        DaoManager.getInstance().getDaoSession().getSearchDao().delete((Search) adapter.getItem(position));

                        //删除适配器内此条数据
                        myAdapter.notifyItemRemoved(position);

                        //删除数据源中此条数据
                        list.remove(position);

                        break;
                }
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = edit.getText().toString();
                Search search = new Search();
                search.setName(string);


                list.clear();

                SearchDao searchDao = DaoManager.getInstance().getDaoSession().getSearchDao();
                searchDao.insert(search);

                List<Search> list1 = searchDao.queryBuilder().orderDesc(SearchDao.Properties.Id).limit(10).build().list();

                list.addAll(list1);

                myAdapter.notifyDataSetChanged();



            }


        });

        showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myRecycler.isFull()){
                    showAll.setText("展开所有");
                    myRecycler.setFull(false);

                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("删除")
                            .setMessage("确定吗？")
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    DaoManager.getInstance().getDaoSession().getSearchDao().deleteAll();

                                    list.clear();

                                    myAdapter.notifyDataSetChanged();
                                }
                            }).show();
                }else {
                    showAll.setText("删除所有");
                    myRecycler.setFull(true);
                }
            }
        });



    }

    private void initView() {

        scrollView = findViewById(R.id.scrollView);
        ll = findViewById(R.id.ll);
        edit = findViewById(R.id.edit);
        search = findViewById(R.id.search);
        showAll = findViewById(R.id.showAll);
        myRecycler = findViewById(R.id.myRecycler);

        list = new ArrayList<>();
    }


}