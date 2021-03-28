package com.example.the_perfect_room.Interface;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.the_perfect_room.Model.AccelerometerData;
import com.example.the_perfect_room.Model.ProximityData;

import java.util.List;

@Dao
public interface DaoAccelerometer {
    @Insert
    void insert(AccelerometerData accelerometerData);

    @Query("DELETE FROM Accelerometer_Sensor")
    void deleteAll();

    @Query("SELECT * FROM Accelerometer_Sensor ORDER BY accelerometer_id ASC")
    LiveData<List<AccelerometerData>> getAllAccelerometerData();
}
