package com.zzw.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.zzw.util.DecorationUtils;

/**
 * Created by zzw on 2017/3/5.
 */

public class GridItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable divider;
    private static final int[] ATTRS=new int[] {
            android.R.attr.listDivider,
    };

    public GridItemDecoration(Context c) {
        TypedArray array=c.obtainStyledAttributes(ATTRS);
        divider=array.getDrawable(0);
        array.recycle();
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        DecorationUtils.onGridVerticalDraw(c, parent, divider);

        View child=parent.getChildAt(0);
        RecyclerView.LayoutParams params=(RecyclerView.LayoutParams) child.getLayoutParams();
        DecorationUtils.onGridHorizontalDraw(c, parent, divider);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        RecyclerView.LayoutManager manager=parent.getLayoutManager();
        if(manager instanceof GridLayoutManager) {
            int position = parent.getChildLayoutPosition(view);
            int spanCount = DecorationUtils.getGridSpanCount(parent);
            int childCount = parent.getAdapter().getItemCount();

            if (DecorationUtils.isGridLastRow(parent, position, spanCount, childCount))
                outRect.set(0, 0, divider.getIntrinsicWidth(), 0);
            else if (DecorationUtils.isGridLastColum(parent, position, spanCount, childCount))
                outRect.set(0, 0, 0, divider.getIntrinsicHeight());
            else
                outRect.set(0, 0, divider.getIntrinsicWidth(), divider.getIntrinsicHeight());
        }
        else {
            outRect.set(0, 0, divider.getIntrinsicWidth(), divider.getIntrinsicHeight());
        }
    }
}
