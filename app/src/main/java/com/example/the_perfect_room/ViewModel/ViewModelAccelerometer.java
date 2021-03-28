package com.example.the_perfect_room.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.the_perfect_room.Model.AccelerometerData;
import com.example.the_perfect_room.Model.ProximityData;
import com.example.the_perfect_room.Repository.AccelerometerRepository;
import com.example.the_perfect_room.Repository.ProximityRepository;

import java.util.List;

public class ViewModelAccelerometer extends AndroidViewModel {

    private AccelerometerRepository accelerometerRepository;
    private LiveData<List<AccelerometerData>> liveDataAccelerometer;

    public ViewModelAccelerometer(@NonNull Application application) {
        super(application);


        accelerometerRepository=new AccelerometerRepository(application);
        liveDataAccelerometer=accelerometerRepository.getListLiveDataAccelerometer();

    }

    public LiveData<List<AccelerometerData>> getLiveDataAccelerometer(){
        return liveDataAccelerometer;
    }

    public void insert(AccelerometerData accelerometerData){

        accelerometerRepository.insert(accelerometerData);

    }

}
