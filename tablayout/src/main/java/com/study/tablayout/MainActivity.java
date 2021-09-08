package com.study.tablayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;

public class MainActivity extends AppCompatActivity implements MyBottomNavigation.MyItemClickListener {


    private MyBottomNavigation mainBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

        mainBottom.addItem(new MyBottomItem("首页",getResources().getDrawable(R.mipmap.ic_launcher)))
                .addItem(new MyBottomItem("标题",null))
                .addItem(new MyBottomItem("标题",null))
                .addItem(new MyBottomItem("标题",null))
                .addItem(new MyBottomItem("标题",null))
                .setBackColor(Color.BLACK)
                .build();

        mainBottom.setMyListener(this);



    }

    private void initView() {
        mainBottom = findViewById(R.id.main_bottom);
    }


    @Override
    public void onSelected(int position) {
        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
    }
}