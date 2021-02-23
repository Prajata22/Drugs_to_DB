package com.applex.drugs_to_db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface DrugsDAOInterface {

    @Insert(onConflict = REPLACE)
    void insert(DrugsModel drugsModel);

    @Query("INSERT INTO ZyephrDatabase.drug_details SELECT * FROM DatabaseHelper.drug_details")
    void insertAll();
}
