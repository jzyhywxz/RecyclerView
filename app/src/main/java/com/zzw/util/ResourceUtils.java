package com.zzw.util;

import android.content.Intent;

import com.zzw.activity.R;
import com.zzw.bean.Animal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zzw on 2017/3/5.
 */

public class ResourceUtils {
    public static List<Integer> getImageResourceIdList() {
        List<Integer> resIdList=new ArrayList<>();
        try {
            for (Field field : R.drawable.class.getDeclaredFields()) {
                if (field.getName().startsWith("image"))
                    resIdList.add((int) field.get(null));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return resIdList;
    }

    public static List<Animal> getAnimals() {
        List<Integer> imgResIdList=getImageResourceIdList();
        List<Animal> animals=new ArrayList<>();
        for(int i=0; i<imgResIdList.size(); i++) {
            Animal animal=new Animal(imgResIdList.get(i), "动物"+(i+1));
            animals.add(animal);
        }
        return animals;
    }

    public static Animal getRandomAnimal() {
        List<Integer> imgResIdList=getImageResourceIdList();
        int index=new Random().nextInt(imgResIdList.size());
        return new Animal(imgResIdList.get(index), "新动物");
    }
}
