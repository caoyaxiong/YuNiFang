package com.bwie.test.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SqLiteDao {

	private SqLiteSjk sqLiteSjk;
	private Person person;
	private ShangPing shangPing;

	public SqLiteDao(Context context) {
		sqLiteSjk = new SqLiteSjk(context);
	}

	public void insert(Person person) {
		SQLiteDatabase db = sqLiteSjk.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", person.getName());
		values.put("phone", person.getPhone());
		values.put("mima", person.getMima());
		db.insert("person", null, values);
		db.close();
	}

	public void delete() {
		SQLiteDatabase db = sqLiteSjk.getWritableDatabase();
		db.execSQL("delete from person ");
		db.close();
	}

	public void deleteSp(){
		SQLiteDatabase db = sqLiteSjk.getWritableDatabase();
		db.execSQL("delete from shangpin ");
		db.close();
	}
	public void insertSp(ShangPing shangPing) {
		SQLiteDatabase db = sqLiteSjk.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", shangPing.getName());
		values.put("imgurl", shangPing.getImgurl());
		values.put("sid", shangPing.getSid());
		values.put("count", shangPing.getCount());
		values.put("price", shangPing.getPrice());
		db.insert("shangping", null, values);
		db.close();
	}

	public void Update(String name, int count) {
		SQLiteDatabase db = sqLiteSjk.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("count", count);
		db.update("shangping", values, "name=?", new String[] { name });
		db.close();
	}

	public Person query(String phone) {
		SQLiteDatabase db = sqLiteSjk.getReadableDatabase();
		Cursor cursor = db.rawQuery("select name,mima,phone from person where phone=" + phone, null);
		while (cursor.moveToNext()) {
			person = new Person();
			person.setName(cursor.getString(cursor.getColumnIndex("name")));
			person.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
			person.setMima(cursor.getString(cursor.getColumnIndex("mima")));
		}
		return person;
	}
	
	public Person queryY() {
		SQLiteDatabase db = sqLiteSjk.getReadableDatabase();
		Cursor cursor = db.rawQuery("select name,mima,phone from person", null);
		while (cursor.moveToNext()) {
			person = new Person();
			person.setName(cursor.getString(cursor.getColumnIndex("name")));
			person.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
			person.setMima(cursor.getString(cursor.getColumnIndex("mima")));
		}
		return person;
	}

	public List<ShangPing> querySp() {
		SQLiteDatabase db = sqLiteSjk.getReadableDatabase();
		Cursor cursor = db.rawQuery("select name,imgurl,sid,count,price from shangping", null);
		List<ShangPing> list = new ArrayList<ShangPing>();
		while (cursor.moveToNext()) {
			shangPing = new ShangPing();
			shangPing.setName(cursor.getString(cursor.getColumnIndex("name")));
			shangPing.setImgurl(cursor.getString(cursor.getColumnIndex("imgurl")));
			shangPing.setCount(cursor.getInt(cursor.getColumnIndex("count")));
			shangPing.setSid(cursor.getString(cursor.getColumnIndex("sid")));
			shangPing.setPrice(cursor.getDouble(cursor.getColumnIndex("price")));
			list.add(shangPing);
		}
		return list;
	}

	public void updatesp(String name) {
		SQLiteDatabase db = sqLiteSjk.getWritableDatabase();
		db.execSQL("delete from shangping where name='" + name + "'");
		db.close();
	}

}
