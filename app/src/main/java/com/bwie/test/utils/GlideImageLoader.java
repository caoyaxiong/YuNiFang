package com.bwie.test.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/17 14:17
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
       
        Glide.with(context).load(path).into(imageView);
    }
    }
