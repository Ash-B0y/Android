package com.example.domestic;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by dhanuskodi on 3/6/2018.
 */

public class databaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "domestic.db";
    private static final int VERSION  = 1;
    private static final String col1="fname";
    private static final String col2="lname";
    private static final String col3="email";
    private static final String col4 ="phonenumber";
    private static final String create =
   "CREATE TABLE record (_id integer primary key autoincrement, "
           + "fname text not null, lname text, "
           + "phonenumber text, "
           + "email text);";




    public databaseHelper(Context context) {
        super(context,DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase  db) {

      db.execSQL(create);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS record");
        onCreate(db);
    }
    public boolean addData(String fname,String lname,String email,String phone)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1,fname);
        contentValues.put(col2,lname);
        contentValues.put(col3,email);
        contentValues.put(col4,phone);
        long result = db.insert("record",null,contentValues);
        if(result == -1)
        {
            return false;
        }
        else {
            return true;
        }


    }
}
