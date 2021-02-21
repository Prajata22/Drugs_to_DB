package com.applex.drugs_to_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME ="Drugs_B.db";
    private static final String TABLE_NAME = "Drugs_B_Table";
    private static final String col2 = "NAME";
    private static final String col3 = "MANUFACTURER";
    private static final String col4 = "CONTENTS";
    private static final String col5 = "CIMS_CLASS";
    private static final String col6 = "ATC_CLASSIFICATION";
    private static final String col7 = "FORM_1";
    private static final String col8 = "PACKING_PRICE_1";
    private static final String col9 = "FORM_2";
    private static final String col10 = "PACKING_PRICE_2";
    private static final String col11 = "FORM_3";
    private static final String col12 = "PACKING_PRICE_3";
    private static final String col13 = "FORM_4";
    private static final String col14 = "PACKING_PRICE_4";
    private static final String col15 = "FORM_5";
    private static final String col16 = "PACKING_PRICE_5";
    private static final String col17 = "FORM_6";
    private static final String col18 = "PACKING_PRICE_6";
    private static final String col19 = "FORM_7";
    private static final String col20 = "PACKING_PRICE_7";
    private static final String col21 = "FORM_8";
    private static final String col22 = "PACKING_PRICE_8";
    private static final String col23 = "FORM_9";
    private static final String col24 = "PACKING_PRICE_9";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + col2 + " TEXT, " + col3 + " TEXT, " + col4 + " TEXT, " + col5 + " TEXT, " + col6 + " TEXT, " + col7 + " TEXT, " + col8 +
                " TEXT, " + col9 + " TEXT, " + col10 + " TEXT, " + col11 + " TEXT, " + col12 + " TEXT, " + col13 + " TEXT, " + col14 +
                " TEXT, " + col15 + " TEXT, " + col16 + " TEXT, " + col17 + " TEXT, " + col18 + " TEXT, " + col19 + " TEXT, " + col20 +
                " TEXT, " + col21 + " TEXT, " + col22 + " TEXT, " + col23 + " TEXT, " + col24 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public boolean addData(String name, String manufacturer, String contents, String cims_class, String atc_classification,
                           String form_1, String packing_price_1, String form_2, String packing_price_2,
                           String form_3, String packing_price_3, String form_4, String packing_price_4,
                           String form_5, String packing_price_5, String form_6, String packing_price_6,
                           String form_7, String packing_price_7, String form_8, String packing_price_8,
                           String form_9, String packing_price_9) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, name);
        contentValues.put(col3, manufacturer);
        contentValues.put(col4, contents);
        contentValues.put(col5, cims_class);
        contentValues.put(col6, atc_classification);
        contentValues.put(col7, form_1);
        contentValues.put(col8, packing_price_1);
        contentValues.put(col9, form_2);
        contentValues.put(col10, packing_price_2);
        contentValues.put(col11, form_3);
        contentValues.put(col12, packing_price_3);
        contentValues.put(col13, form_4);
        contentValues.put(col14, packing_price_4);
        contentValues.put(col15, form_5);
        contentValues.put(col16, packing_price_5);
        contentValues.put(col17, form_6);
        contentValues.put(col18, packing_price_6);
        contentValues.put(col19, form_7);
        contentValues.put(col20, packing_price_7);
        contentValues.put(col21, form_8);
        contentValues.put(col22, packing_price_8);
        contentValues.put(col23, form_9);
        contentValues.put(col24, packing_price_9);

        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }
}