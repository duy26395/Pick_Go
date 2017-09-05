package com.example.mypc.i_tour.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mypc.i_tour.Data.Data_favorite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 07/08/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "List_favorite";
    private static final String TABLE_NAME = "favorite";
    private static final String ID_KEY ="id";
    private static final String NAME_KEY ="name";
    private static final String INTRO_KEY ="intro";
    private static final String IMAGE_KEY = "image";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String script = "CREATE TABLE " + TABLE_NAME + "("
                + ID_KEY + " INTEGER PRIMARY KEY,"
                + NAME_KEY + " TEXT,"
                + INTRO_KEY + " TEXT,"
                + IMAGE_KEY + " TEXT" + ")";
        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public long addTEAM(Data_favorite data){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
//        values.put(ID_KEY,data.getId());
        values.put(NAME_KEY,data.getName());
        values.put(INTRO_KEY,data.getIntro());
        values.put(IMAGE_KEY,data.getImage());
        long result = db.insert(TABLE_NAME,null,values);
        db.close();
        return result;
    }
    public Data_favorite getData(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,new String[]{ID_KEY,NAME_KEY,INTRO_KEY,IMAGE_KEY},ID_KEY +"=?", new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor!=null) cursor.moveToFirst();
        else return new Data_favorite(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
        return null;
    }
    public List<Data_favorite> getallteam(){
        List<Data_favorite> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuerry = "SELECT  * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuerry, null);
        if (cursor.moveToFirst()) {
            do {
                data.add(new Data_favorite(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public void update(Data_favorite data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_KEY,data.getName());
        values.put(INTRO_KEY,data.getIntro());
        values.put(IMAGE_KEY,data.getImage());
        db.update(TABLE_NAME,values,ID_KEY +"=?",new String[]{String.valueOf(data.getId())});
        db.close();
    }
    public void delete(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_NAME,ID_KEY +"=?", new String[]{String.valueOf(id)});
        db.close();
    }
    public int getCount(){//đếm số phần tử của Data đã ghi
        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

}
