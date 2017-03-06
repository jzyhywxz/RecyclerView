package com.zzw.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.zzw.adapter.VerticalItemDecoration;
import com.zzw.adapter.ViewAdapter;
import com.zzw.bean.Animal;
import com.zzw.util.ResourceUtils;

import java.util.List;

public class VerticalActivity extends AppCompatActivity {
    private RecyclerView view;
    private ViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        view=(RecyclerView) findViewById(R.id.vert_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        List<Animal> datas= ResourceUtils.getAnimals();
        adapter=new ViewAdapter(this, datas, R.layout.item_vertical, R.id.vert_image, R.id.vert_text, true);
        view.setAdapter(adapter);
        view.addItemDecoration(new VerticalItemDecoration(this));
        view.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                adapter.addItem(0);
                view.smoothScrollToPosition(0);
                break;
            case R.id.remove:
                adapter.removeItem(0);
                break;
            default:break;
        }
        return true;
    }
}
