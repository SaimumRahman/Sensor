package com.example.the_perfect_room.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.the_perfect_room.Model.GyroscopeData;
import com.example.the_perfect_room.Model.LightData;
import com.example.the_perfect_room.Model.ProximityData;
import com.example.the_perfect_room.Repository.GyroscopeRepository;
import com.example.the_perfect_room.Repository.LightRepository;
import com.example.the_perfect_room.Repository.ProximityRepository;

import java.util.List;

public class ViewModelGyroscope extends AndroidViewModel {

    private GyroscopeRepository gyroscopeRepository;
    private LiveData<List<GyroscopeData>> listLiveDataGyroscope;

    public ViewModelGyroscope(@NonNull Application application) {
        super(application);

        gyroscopeRepository=new GyroscopeRepository(application);
        listLiveDataGyroscope=gyroscopeRepository.getListLiveDataGyroscope();

    }

    public LiveData<List<GyroscopeData>> getListLiveDataGyroscope(){
        return listLiveDataGyroscope;
    }

    public void insert(GyroscopeData gyroscopeData){

        gyroscopeRepository.insert(gyroscopeData);

    }
}
