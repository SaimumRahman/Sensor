package com.example.the_perfect_room.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

import com.example.the_perfect_room.Interface.DaoAccelerometer;
import com.example.the_perfect_room.Interface.DaoGyroscope;
import com.example.the_perfect_room.Interface.DaoProximity;
import com.example.the_perfect_room.Interface.LightDao;
import com.example.the_perfect_room.Model.AccelerometerData;
import com.example.the_perfect_room.Model.GyroscopeData;
import com.example.the_perfect_room.Model.LightData;
import com.example.the_perfect_room.Model.ProximityData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {LightData.class, AccelerometerData.class, GyroscopeData.class, ProximityData.class},version =15)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {

    public abstract LightDao lightDao();
    public abstract DaoAccelerometer daoAccelerometer();
    public abstract DaoProximity daoProximity();
    public abstract DaoGyroscope daoGyroscope();
    private static RoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 6;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static RoomDatabase getRoomDatabase(final Context context){
        if( INSTANCE ==null){
            synchronized (RoomDatabase.class){
                if (INSTANCE==null){
                    //Create Database
                    INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                            RoomDatabase.class,"Sensor_database")
                            .fallbackToDestructiveMigration()

                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
