package com.zzw.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.zzw.adapter.HorizontalItemDecoration;
import com.zzw.adapter.ViewAdapter;
import com.zzw.bean.Animal;
import com.zzw.util.ResourceUtils;

import java.util.List;

public class HorizontalActivity extends AppCompatActivity {
    private RecyclerView view;
    private ViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        view=(RecyclerView) findViewById(R.id.hori_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        view.setLayoutManager(layoutManager);
        List<Animal> datas= ResourceUtils.getAnimals();
        adapter=new ViewAdapter(this, datas, R.layout.item_horizontal, R.id.hori_image, R.id.hori_text, true);
        view.setAdapter(adapter);
        view.addItemDecoration(new HorizontalItemDecoration(this));
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
