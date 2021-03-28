package com.example.the_perfect_room.Interface;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.the_perfect_room.Model.LightData;
import com.example.the_perfect_room.Model.ProximityData;

import java.util.List;
@Dao
public interface DaoProximity {
    @Insert
    void insert(ProximityData proximityData);

    @Query("DELETE FROM Proximity_Sensor")
    void deleteAll();

    @Query("SELECT * FROM Proximity_Sensor ORDER BY proximityId ASC")
    LiveData<List<ProximityData>> getAllProximityData();
}
