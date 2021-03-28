package com.example.the_perfect_room.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.the_perfect_room.Interface.DaoAccelerometer;
import com.example.the_perfect_room.Interface.DaoGyroscope;
import com.example.the_perfect_room.Interface.DaoProximity;
import com.example.the_perfect_room.Interface.LightDao;
import com.example.the_perfect_room.Model.LightData;
import com.example.the_perfect_room.Database.RoomDatabase;

import java.util.List;

public class LightRepository {

    private LightDao lightDao;
    private LiveData<List<LightData>>lightDataLive;

    public LightRepository(Application application){

        RoomDatabase roomDatabase= RoomDatabase.getRoomDatabase(application);
        lightDao=roomDatabase.lightDao();
        lightDataLive=lightDao.getAllLightData();

    }

    public LiveData<List<LightData>>getLightDataLive(){
        return lightDataLive;
    }

    public void insert(LightData lightSensor){
        RoomDatabase.databaseWriteExecutor.execute(() ->{
            lightDao.insert(lightSensor);
        });
    }
}
