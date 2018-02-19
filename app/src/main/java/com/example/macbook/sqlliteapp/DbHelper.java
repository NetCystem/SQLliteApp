package com.example.macbook.sqlliteapp;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;

/**
 * Created by MAcBook on 03/02/2018.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String Dbname = "myDb";
    private String Table_name = "Java";
    private String col_id = "Id";
    private String col_name = "Name";
    private String col_age = "Age";


    public DbHelper(Context context) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Java (Id Integer Primary Key Autoincrement," + "Name VarChar (15) Not Null, Age TEXT Not Null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table If Exists JAVA" );

    }

    public boolean myInsert(String name, String age){
        SQLiteDatabase sqLiteDatabase  = getWritableDatabase();
        ContentValues  contentValues = new ContentValues();
        contentValues.put(col_name,name);
        contentValues.put(col_age,age);

        long i = sqLiteDatabase.insert(Table_name, null, contentValues);

        if (i==-1){

            return false;
        }else {
            return true;
        }

    }

    public Cursor getDates(){
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery ("select * from Java", null);
        return cursor;
    }

    public boolean myUpdate(String id, String name, String age){
        SQLiteDatabase sqLiteDatabase  = getWritableDatabase();
        ContentValues  contentValues = new ContentValues();
        contentValues.put(col_name,name);
        contentValues.put(col_age,age);
        int j = sqLiteDatabase.update(Table_name, contentValues, "ID=?", new String[]{id});


        if (j==-1){

            return false;
        }else {
            return true;
        }
    }


    public  void deleByID(String id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(Table_name, "ID=?", new String[]{id});



    }
}
