package com.example.vishaldeepsingh.vsafe.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vishaldeep Singh on 15-Oct-16.
 */

public class Dbhelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Mydb.db";
    public static final String TABLE_NAME="user_info";
    public static final String TABLE_NAME1="user_info1";
    public static final String NAME="Username";
    public static final String EmailId="Emailid";
    public static final String Phoneno="Phoneno";
    public static final String Address="addresss";

    public static final String NAME1="Personname1";
    public static final String Phoneno1="phoneno1";
    public static final String NAME2="Personname2";
    public static final String Phoneno2="phoneno2";

    public Dbhelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        // TODO Auto-generated constructor stub
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user_info"+"(Username text not null,Emailid text not null primary key,Phoneno integer not null,addresss text not null )");
        db.execSQL("create table user_info1"+"(Personname1 text not null,phoneno1 integer not null,Personname2 text not null,phoneno2 integer not null )");


    }
    public boolean insertcontact(String name,String email,String phn,String add)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("Username",name);
        cv.put("Emailid",email);
        cv.put("Phoneno", phn);
        cv.put("addresss",add);
        db.insert("user_info", null, cv);
        return true;

    }
    public boolean insertcontact1(String name1,String phn1,String name2,String phn2)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("Personname1",name1);
        cv.put("phoneno1",phn1);
        cv.put("Personname2", name2);
        cv.put("phoneno2",phn2);
        db.insert("user_info1", null, cv);
        return true;

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
