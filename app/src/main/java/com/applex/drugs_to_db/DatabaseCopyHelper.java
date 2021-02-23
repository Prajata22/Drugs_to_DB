package com.applex.drugs_to_db;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DatabaseCopyHelper extends SQLiteOpenHelper {

    private SQLiteDatabase myDataBase;
    private final Context myContext;
    private final String DATABASE_NAME;
    private final String TABLE_NAME;

    private static final String col1 = "ID";
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

    @SuppressLint("SdCardPath")
    public final static String DATABASE_PATH = "/data/data/com.applex.drugs_to_db/databases/";
    public static final int DATABASE_VERSION = 1;

    public DatabaseCopyHelper(Context context, String database_name, String table_name) {
        super(context, database_name, null, DATABASE_VERSION);
        this.myContext = context;
        this.DATABASE_NAME = database_name;
        this.TABLE_NAME = table_name;
    }

    //Create a empty database on the system
    public void createDatabase() throws IOException {
        boolean dbExist = checkDataBase();
        if(dbExist) {
            Log.v("DB Exists", "db exists");
            // By calling this method here onUpgrade will be called on a
            // writeable database, but only if the version number has been
            // bumped
            //onUpgrade(myDataBase, DATABASE_VERSION_old, DATABASE_VERSION);
        }

        boolean dbExist1 = checkDataBase();
        if(!dbExist1) {
            this.getReadableDatabase();
            try {
                this.close();
                copyDataBase();
            }
            catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    //Check database already exist or not
    private boolean checkDataBase() {
        boolean checkDB = false;
        try {
            String myPath = DATABASE_PATH + DATABASE_NAME;
            File dbfile = new File(myPath);
            checkDB = dbfile.exists();
        }
        catch(SQLiteException e) {
            Log.v("ThrownError", e.getMessage());
        }
        return checkDB;
    }

    //Copies your database from your local assets-folder to the just created empty database in the system folder
    private void copyDataBase() throws IOException {
        InputStream mInput = myContext.getAssets().open(DATABASE_NAME);

        String outFileName = DATABASE_PATH + DATABASE_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[2024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    //delete database
    public void db_delete() {
        File file = new File(DATABASE_PATH + DATABASE_NAME);
        if(file.exists()) {
            file.delete();
            System.out.println("delete database file.");
        }
    }

    //Open database
    public void openDatabase() throws SQLException {
        String myPath = DATABASE_PATH + DATABASE_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public synchronized void closeDataBase()throws SQLException {
        if(myDataBase != null)
            myDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            Log.v("Database Upgrade", "Database version higher than old.");
            db_delete();
        }
    }

    public ArrayList<Drugs_A_Model> getAllDrugs() {
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if(cursor.getCount() < 1)
            return null;

        ArrayList<Drugs_A_Model> data = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Drugs_A_Model drugsModel = new Drugs_A_Model();
                drugsModel.setID(cursor.getInt(cursor.getColumnIndex(col1)));
                drugsModel.setName(cursor.getString(cursor.getColumnIndex(col2)));
                drugsModel.setCompany_name(cursor.getString(cursor.getColumnIndex(col3)));
                drugsModel.setContents(cursor.getString(cursor.getColumnIndex(col4)));
                drugsModel.setCims_class(cursor.getString(cursor.getColumnIndex(col5)));
                drugsModel.setAtc_classification(cursor.getString(cursor.getColumnIndex(col6)));
                drugsModel.setForm_1(cursor.getString(cursor.getColumnIndex(col7)));
                drugsModel.setPacking_price_1(cursor.getString(cursor.getColumnIndex(col8)));
                drugsModel.setForm_2(cursor.getString(cursor.getColumnIndex(col9)));
                drugsModel.setPacking_price_2(cursor.getString(cursor.getColumnIndex(col10)));
                drugsModel.setForm_3(cursor.getString(cursor.getColumnIndex(col11)));
                drugsModel.setPacking_price_3(cursor.getString(cursor.getColumnIndex(col12)));
                drugsModel.setForm_4(cursor.getString(cursor.getColumnIndex(col13)));
                drugsModel.setPacking_price_4(cursor.getString(cursor.getColumnIndex(col14)));
                drugsModel.setForm_5(cursor.getString(cursor.getColumnIndex(col15)));
                drugsModel.setPacking_price_5(cursor.getString(cursor.getColumnIndex(col16)));
                drugsModel.setForm_6(cursor.getString(cursor.getColumnIndex(col17)));
                drugsModel.setPacking_price_6(cursor.getString(cursor.getColumnIndex(col18)));
                drugsModel.setForm_7(cursor.getString(cursor.getColumnIndex(col19)));
                drugsModel.setPacking_price_7(cursor.getString(cursor.getColumnIndex(col20)));
                drugsModel.setForm_8(cursor.getString(cursor.getColumnIndex(col21)));
                drugsModel.setPacking_price_8(cursor.getString(cursor.getColumnIndex(col22)));
                drugsModel.setForm_9(cursor.getString(cursor.getColumnIndex(col23)));
                drugsModel.setPacking_price_9(cursor.getString(cursor.getColumnIndex(col24)));

                data.add(drugsModel);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return data;
    }
}