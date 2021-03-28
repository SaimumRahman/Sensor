package com.example.the_perfect_room.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.the_perfect_room.Database.RoomDatabase;
import com.example.the_perfect_room.Interface.DaoAccelerometer;
import com.example.the_perfect_room.Model.AccelerometerData;
import com.example.the_perfect_room.Model.LightData;

import java.util.List;

public class AccelerometerRepository {
    private DaoAccelerometer daoAccelerometer;
    private LiveData<List<AccelerometerData>> listLiveDataAccelerometer;

    public AccelerometerRepository(Application application){

        RoomDatabase database=RoomDatabase.getRoomDatabase(application);
        daoAccelerometer=database.daoAccelerometer();
        listLiveDataAccelerometer=daoAccelerometer.getAllAccelerometerData();

    }

    public LiveData<List<AccelerometerData>>getListLiveDataAccelerometer(){
        return listLiveDataAccelerometer;
    }

    public void insert(AccelerometerData accelerometerData){
        RoomDatabase.databaseWriteExecutor.execute(() ->{
            daoAccelerometer.insert(accelerometerData);
        });
    }

}
