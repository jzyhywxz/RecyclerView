package com.zzw.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button vertButton;
    private Button horiButton;
    private Button gridButton;
    private Button staggeredButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
        initEvent();
    }

    private void initView() {
        vertButton=(Button) findViewById(R.id.vert_button);
        horiButton=(Button) findViewById(R.id.hori_button);
        gridButton=(Button) findViewById(R.id.grid_button);
        staggeredButton=(Button) findViewById(R.id.staggered_button);
    }

    private void initEvent() {
        vertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, VerticalActivity.class);
                startActivity(intent);
            }
        });
        horiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, HorizontalActivity.class);
                startActivity(intent);
            }
        });
        gridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, GridActivity.class);
                startActivity(intent);
            }
        });
        staggeredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, StaggeredGridActivity.class);
                startActivity(intent);
            }
        });
    }
}
