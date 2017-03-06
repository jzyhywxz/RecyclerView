package com.zzw.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zzw.util.DecorationUtils;

/**
 * Created by zzw on 2017/3/5.
 */

public class VerticalItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable divider;
    private static final int[] ATTRS=new int[] {
            android.R.attr.listDivider,
    };

    public VerticalItemDecoration(Context c) {
        TypedArray array=c.obtainStyledAttributes(ATTRS);
        divider=array.getDrawable(0);
        array.recycle();
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        DecorationUtils.onVerticalDraw(c, parent, divider);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position=parent.getChildLayoutPosition(view);
        int childCount=parent.getAdapter().getItemCount();
        if((position+1)<childCount)
            outRect.set(0, 0, 0, divider.getIntrinsicHeight());
    }
}
