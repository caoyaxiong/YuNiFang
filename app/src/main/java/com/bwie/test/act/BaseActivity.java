package com.bwie.test.act;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bwie.test.utils.ContextUtil;


/**
 * 这个类所有activity的基类  所有acitivity共有的方法都写在这里
 * Created by jinguo on 2017/3/16.
 */

public class BaseActivity  extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //将每个acitivty加到集合中，方便再退出的时候一次退出
        ContextUtil.addActivity(this);
    }
}
