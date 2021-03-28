package com.example.the_perfect_room.Interface;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.the_perfect_room.Model.LightData;

import java.util.List;

@Dao
public interface LightDao {

    @Insert
    void insert(LightData lightData);

    @Query("DELETE FROM Light_Sensor")
    void deleteAll();

    @Query("SELECT * FROM Light_Sensor ORDER BY lightId ASC")
    LiveData<List<LightData>> getAllLightData();

}
