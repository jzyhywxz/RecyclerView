package com.zzw.util;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/**
 * Created by zzw on 2017/3/5.
 */

public class DecorationUtils {
    public static void onVerticalDraw(Canvas c, RecyclerView parent, Drawable divider) {
        int left=parent.getPaddingLeft();
        int right=parent.getWidth()-parent.getPaddingRight();

        for(int i=0; i<parent.getChildCount()-1; i++) {
            View child=parent.getChildAt(i);
            RecyclerView.LayoutParams params=(RecyclerView.LayoutParams) child.getLayoutParams();
            int top=child.getBottom()+params.bottomMargin;
            int bottom=top+divider.getIntrinsicHeight();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }

    public static void onHorizontalDraw(Canvas c, RecyclerView parent, Drawable divider) {
        int top=parent.getPaddingTop();
        int bottom=parent.getHeight()-parent.getPaddingBottom();

        for(int i=0; i<parent.getChildCount()-1; i++) {
            View child=parent.getChildAt(i);
            RecyclerView.LayoutParams params=(RecyclerView.LayoutParams) child.getLayoutParams();
            int left=child.getRight()+params.rightMargin;
            int right=left+divider.getIntrinsicWidth();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }

    public static void onGridVerticalDraw(Canvas c, RecyclerView parent, Drawable divider) {
        for(int i=0; i<parent.getChildCount(); i++) {
            View child=parent.getChildAt(i);
            RecyclerView.LayoutParams params=(RecyclerView.LayoutParams) child.getLayoutParams();

            int left=child.getLeft()-params.leftMargin;
            int top=child.getBottom()+params.bottomMargin;
            int right=child.getRight()+params.rightMargin+divider.getIntrinsicHeight();
            int bottom=top+divider.getIntrinsicHeight();

            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }

    public static void onGridHorizontalDraw(Canvas c, RecyclerView parent, Drawable divider) {
        for(int i=0; i<parent.getChildCount(); i++) {
            View child=parent.getChildAt(i);
            RecyclerView.LayoutParams params=(RecyclerView.LayoutParams) child.getLayoutParams();

            int left=child.getRight()+params.rightMargin;
            int top=child.getTop()-params.topMargin;
            int right=left+divider.getIntrinsicWidth();
            int bottom=child.getBottom()+params.bottomMargin;

            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }

    public static int getGridSpanCount(RecyclerView parent) {
        int spanCount=-1;
        RecyclerView.LayoutManager layoutManager=parent.getLayoutManager();
        if(layoutManager instanceof GridLayoutManager)
            spanCount=((GridLayoutManager) layoutManager).getSpanCount();
        else if(layoutManager instanceof StaggeredGridLayoutManager)
            spanCount=((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        return spanCount;
    }

    public static boolean isGridLastColum(RecyclerView parent, int position, int spanCount, int childCount) {
        RecyclerView.LayoutManager layoutManager=parent.getLayoutManager();
        if(layoutManager instanceof GridLayoutManager)
            return (position+1)%spanCount==0;
        else if(layoutManager instanceof StaggeredGridLayoutManager) {
            int orientation=((StaggeredGridLayoutManager) layoutManager).getOrientation();
            if(orientation==StaggeredGridLayoutManager.VERTICAL)
                return (position+1)%spanCount==0;
            else
                return position>=(childCount-childCount%spanCount);
        }
        return false;
    }

    public static boolean isGridLastRow(RecyclerView parent, int position, int spanCount, int childCount) {
        RecyclerView.LayoutManager layoutManager=parent.getLayoutManager();
        if(layoutManager instanceof GridLayoutManager)
            return position>=(childCount-childCount%spanCount);
        else if(layoutManager instanceof StaggeredGridLayoutManager) {
            int orientation=((StaggeredGridLayoutManager) layoutManager).getOrientation();
            if(orientation==StaggeredGridLayoutManager.VERTICAL)
                return position>=(childCount-childCount%spanCount);
            else
                return (position+1)%spanCount==0;
        }
        return false;
    }
}
