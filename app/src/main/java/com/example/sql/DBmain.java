package com.example.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBmain extends SQLiteOpenHelper {
    public static final String Database="user.db";
    public DBmain(@Nullable Context context) {
        super(context, Database, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create Table users(username Text primary key,password Integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table if exists users");
    }

    public boolean insertdata(String username,String password)
    {
        SQLiteDatabase mydb=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result=mydb.insert("users",null,contentValues);

        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public Boolean chechusername(String username){
        SQLiteDatabase mydb=this.getWritableDatabase();
        Cursor cursor=mydb.rawQuery("Select * from users where username=?",new String[]{username});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }

    }
    public Boolean chechusernamepassword(String username,String password)
    {
        SQLiteDatabase mydb=this.getWritableDatabase();
        Cursor cursor=mydb.rawQuery("Select * from users where username=? and password=?",new String[]{username,password});
        if(cursor.getCount()>0)
        {
            return  true;
        }
        else {
            return false;
        }
    }
}
