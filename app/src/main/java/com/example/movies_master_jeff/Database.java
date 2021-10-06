package com.example.movies_master_jeff;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    //db naam
    public static String DATABASE_NAME = "database_project_MMJ.db";
    //tabel 1
    public static final String DATABASE_table_1 = "object";
    public static final String Table_1_col_0 = "object_id";
    public static final String Table_1_col_1 = "object_naam";
    public static final String Table_1_col_2 = "object_type";

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DATABASE_table_1 + "(" + Table_1_col_0 + " INTEGER DEFAULT 0 primary key ,"
        + Table_1_col_1 + " TEXT ," + Table_1_col_2 + " INTEGER default 0)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_table_1);
    }

    public int IDMAKER_TABLE_1(){
        int uit = -1;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from " + DATABASE_table_1, null
        );
        if (cursor.getCount() == 0) {
            uit = 0;
        } else {
            Cursor cursor1 = sqLiteDatabase.rawQuery("select max(" + Table_1_col_0 + " ) from " + DATABASE_table_1 + "", null);
            StringBuffer stringBuffer = new StringBuffer();
            if (cursor1.moveToFirst()) {
                stringBuffer.append(cursor1.getString(0));
                uit = Integer.parseInt(stringBuffer.toString()) + 1;
            }
        }
        return uit;
    }
    public void addToTabel1(String naam, int type) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Table_1_col_0, IDMAKER_TABLE_1());
        contentValues.put(Table_1_col_1, naam);
        contentValues.put(Table_1_col_2, type);

        sqLiteDatabase.insert(DATABASE_table_1, null, contentValues);
    }


    public ArrayList<String> namen() {

        ArrayList<String> uits = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select " + Table_1_col_1 + " from " + DATABASE_table_1 + "", null);

        for (int i = 0; i <= cursor.getCount(); i++) {
            if (cursor.moveToPosition(i)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(cursor.getString(0));
                uits.add(stringBuffer.toString());
            }
        }
        return uits;
    }
}
