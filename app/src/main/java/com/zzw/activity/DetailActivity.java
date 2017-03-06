package com.zzw.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        int imgResId=intent.getIntExtra("IMG_RES_ID", R.drawable.hello);
        String description=intent.getStringExtra("DESCRIPTION");
        if(description==null)
            description="默认图片";
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imageView=(ImageView) findViewById(R.id.detail_image);
        TextView textView=(TextView) findViewById(R.id.detail_text);

        Glide.with(this).load(imgResId).into(imageView);
        textView.setText(description);
    }
}
