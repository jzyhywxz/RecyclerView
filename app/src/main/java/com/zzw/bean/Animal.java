package com.zzw.bean;

/**
 * Created by zzw on 2017/3/5.
 */

public class Animal {
    private int imgResId;
    private String description;

    public Animal(int i, String d) {
        imgResId=i;
        description=d;
    }

    public int getImgResId() { return imgResId; }
    public String getDescription() { return description; }
}
