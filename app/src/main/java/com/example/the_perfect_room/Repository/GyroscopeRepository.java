package com.example.the_perfect_room.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.the_perfect_room.Database.RoomDatabase;
import com.example.the_perfect_room.Interface.DaoGyroscope;
import com.example.the_perfect_room.Interface.LightDao;
import com.example.the_perfect_room.Model.GyroscopeData;
import com.example.the_perfect_room.Model.LightData;

import java.util.List;

public class GyroscopeRepository {

    private DaoGyroscope daoGyroscope;
    private LiveData<List<GyroscopeData>> listLiveDataGyroscope;

    public GyroscopeRepository(Application application){

        RoomDatabase roomDatabase= RoomDatabase.getRoomDatabase(application);
        daoGyroscope=roomDatabase.daoGyroscope();
        listLiveDataGyroscope=daoGyroscope.getAllGyroscopeData();

    }

    public LiveData<List<GyroscopeData>>getListLiveDataGyroscope(){
        return listLiveDataGyroscope;
    }

    public void insert(GyroscopeData gyroscopeData){
        RoomDatabase.databaseWriteExecutor.execute(() ->{
            daoGyroscope.insert(gyroscopeData);
        });
    }
}
