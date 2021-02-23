package com.applex.drugs_to_db;

import androidx.room.Dao;
import androidx.room.Query;
import java.util.List;

@Dao
public interface DrugsDummyDAOInterface {

    @Query("SELECT * FROM Drugs_A_Model")
    List<Drugs_A_Model> getAllDrugs();
}
