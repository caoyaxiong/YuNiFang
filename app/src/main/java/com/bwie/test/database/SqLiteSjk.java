package com.bwie.test.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 1.数据库
 * 2.张杰
 * 3.2016/12/16
 */
public class SqLiteSjk extends SQLiteOpenHelper {


    public SqLiteSjk(Context context) {
        super(context,  "yunifang.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table person(id integer primary key autoincrement,phone varchar(100),name varchar(100),mima varchar(100))");
        db.execSQL("create table shangping(id integer primary key autoincrement,name varchar(100),imgurl varchar(100),sid varchar(100),count integer(100),price double(100))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
