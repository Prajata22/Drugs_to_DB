package com.applex.drugs_to_db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Drugs_A_Model.class}, version = 1, exportSchema = false)
public abstract class ZyephrCopyDatabase extends RoomDatabase {

    public static ZyephrCopyDatabase getDatabase(final Context context, String name, String db_name) {
        return Room.databaseBuilder(context.getApplicationContext(), ZyephrCopyDatabase.class, db_name)
                .createFromAsset(name)
                .fallbackToDestructiveMigration()  // Delete db
                .build();
    }

    public abstract DrugsDummyDAOInterface drugsDummyDAOInterface();
}
