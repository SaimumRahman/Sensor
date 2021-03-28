package com.example.the_perfect_room.Interface;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.the_perfect_room.Model.GyroscopeData;
import com.example.the_perfect_room.Model.ProximityData;

import java.util.List;

@Dao
public interface DaoGyroscope {


    @Insert
    void insert(GyroscopeData proximityData);

    @Query("DELETE FROM Gyroscope_table")
    void deleteAll();

    @Query("SELECT * FROM Gyroscope_table ORDER BY Gyroscope_id ASC")
    LiveData<List<GyroscopeData>> getAllGyroscopeData();
}
