package com.xitong.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.xitong.Bean.contacts;
import com.xitong.utils.DBUtils;

import java.util.ArrayList;
import java.util.List;


public class SQLiteHelper extends SQLiteOpenHelper {
    private SQLiteDatabase sqLiteDatabase;
    //创建数据库
    public SQLiteHelper(Context context){
        super(context, DBUtils.DATABASE_NAME, null, DBUtils.DATABASE_VERION);
        sqLiteDatabase = this.getWritableDatabase();
    }
    //创建表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+DBUtils.DATABASE_TABLE+"("+DBUtils.ITEM_ID+
                " integer primary key autoincrement,"
                +DBUtils.ITEM_STUNUMBER+" text,"+ DBUtils.ITEM_NAME +
                " text," + DBUtils.ITEM_SEX +
                " text," + DBUtils.ITEM_ZHUANYE +
                " text," + DBUtils.ITEM_PHONENUMBER+ " text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
    //添加数据
    public boolean insertData(String stunumber,String name,String sex,String zhuanye,String phonenumber){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DBUtils.ITEM_STUNUMBER,stunumber);
        contentValues.put(DBUtils.ITEM_NAME,name);
        contentValues.put(DBUtils.ITEM_SEX,sex);
        contentValues.put(DBUtils.ITEM_ZHUANYE,zhuanye);
        contentValues.put(DBUtils.ITEM_PHONENUMBER,phonenumber);
        return sqLiteDatabase.insert(DBUtils.DATABASE_TABLE,null,contentValues)>0;
    }
    //查询数据
    public List<contacts> query(){
        List<contacts> list=new ArrayList<contacts>();
        Cursor cursor=sqLiteDatabase.query(DBUtils.DATABASE_TABLE,null,null,null,
                null,null,DBUtils.ITEM_ID+" desc");
        if (cursor!=null){
            while (cursor.moveToNext()){
                contacts noteInfo=new contacts();
                @SuppressLint("Range") String id = String.valueOf(cursor.getInt
                        (cursor.getColumnIndex(DBUtils.ITEM_ID)));
                @SuppressLint("Range") String stuNumber = cursor.getString(cursor.getColumnIndex
                        (DBUtils.ITEM_STUNUMBER));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex
                        (DBUtils.ITEM_NAME));
                @SuppressLint("Range") String sex = cursor.getString(cursor.getColumnIndex
                        (DBUtils.ITEM_SEX));
                @SuppressLint("Range") String zhuanye = cursor.getString(cursor.getColumnIndex
                        (DBUtils.ITEM_ZHUANYE));
                @SuppressLint("Range") String phoneNumber = cursor.getString(cursor.getColumnIndex
                        (DBUtils.ITEM_PHONENUMBER));
                noteInfo.setId(id);
                noteInfo.setStuNumber(stuNumber);
                noteInfo.setName(name);
                noteInfo.setSex(sex);
                noteInfo.setZhuangye(zhuanye);
                noteInfo.setPhoneNumber(phoneNumber);
                list.add(noteInfo);
            }
            cursor.close();
        }
        return list;
    }
}
