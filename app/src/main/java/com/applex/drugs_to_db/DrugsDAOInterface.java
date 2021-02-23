package com.applex.drugs_to_db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface DrugsDAOInterface {

    @Insert(onConflict = REPLACE)
    void insert(Drugs_A_Model drugsModel);

    @Query("SELECT * FROM Drugs_A_Model WHERE ID = :id")
    Drugs_A_Model getDrugs(int id);
}
