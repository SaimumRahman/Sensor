package com.example.the_perfect_room.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.the_perfect_room.Database.RoomDatabase;
import com.example.the_perfect_room.Interface.DaoGyroscope;
import com.example.the_perfect_room.Interface.DaoProximity;
import com.example.the_perfect_room.Model.GyroscopeData;
import com.example.the_perfect_room.Model.ProximityData;

import java.util.List;

public class ProximityRepository {

    private DaoProximity daoProximity;
    private LiveData<List<ProximityData>> listLiveDataProximity;

    public ProximityRepository(Application application){

        RoomDatabase roomDatabase= RoomDatabase.getRoomDatabase(application);
        daoProximity=roomDatabase.daoProximity();
        listLiveDataProximity=daoProximity.getAllProximityData();

    }

    public LiveData<List<ProximityData>>getListLiveDataProximity(){
        return listLiveDataProximity;
    }

    public void insert(ProximityData proximityData){
        RoomDatabase.databaseWriteExecutor.execute(() ->{
            daoProximity.insert(proximityData);
        });
    }

}
