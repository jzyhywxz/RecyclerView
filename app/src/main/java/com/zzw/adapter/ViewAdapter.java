package com.zzw.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zzw.activity.DetailActivity;
import com.zzw.bean.Animal;
import com.zzw.util.ResourceUtils;

import java.util.List;

/**
 * Created by zzw on 2017/3/5.
 */

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {
    private Context context;
    private List<Animal> datas;
    private int layoutResId;
    private int imageViewId;
    private int textViewId;
    private boolean isCenterCrop;

    public ViewAdapter(Context c, List<Animal> list, int lri, int ivi, int tvi, boolean centerCrop) {
        context=c;
        datas=list;
        layoutResId=lri;
        imageViewId=ivi;
        textViewId=tvi;
        isCenterCrop=centerCrop;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(layoutResId, parent, false);
        return new ViewHolder(view, imageViewId, textViewId);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Animal animal=datas.get(position);
        if(isCenterCrop)
            Glide.with(context).load(animal.getImgResId()).centerCrop().into(holder.imageView);
        else
            Glide.with(context).load(animal.getImgResId()).into(holder.imageView);
        holder.textView.setText(animal.getDescription());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("IMG_RES_ID", animal.getImgResId());
                intent.putExtra("DESCRIPTION", animal.getDescription());
                context.startActivity(intent);
            }
        });
        holder.view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context, "第"+position+"个元素", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addItem(int position) {
        datas.add(position, ResourceUtils.getRandomAnimal());
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        if(position>=0 && position<datas.size()) {
            datas.remove(position);
            notifyItemRemoved(position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView, int ivi, int tvi) {
            super(itemView);
            view=itemView;
            imageView=(ImageView) itemView.findViewById(ivi);
            textView=(TextView) itemView.findViewById(tvi);
        }
    }
}
