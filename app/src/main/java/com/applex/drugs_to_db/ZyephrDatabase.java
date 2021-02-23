package com.applex.drugs_to_db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Drugs_A_Model.class}, version = 1, exportSchema = false)
public abstract class ZyephrDatabase extends RoomDatabase {

    private static ZyephrDatabase INSTANCE;

    public static ZyephrDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ZyephrDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ZyephrDatabase.class, "Drugs_Database")
                            .fallbackToDestructiveMigration()  // Delete db
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract DrugsDAOInterface drugsDAOInterface();
}
