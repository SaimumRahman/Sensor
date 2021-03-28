package com.example.the_perfect_room.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.the_perfect_room.Model.LightData;
import com.example.the_perfect_room.Model.ProximityData;
import com.example.the_perfect_room.Repository.LightRepository;
import com.example.the_perfect_room.Repository.ProximityRepository;

import java.util.List;

public class ViewModelProximity extends AndroidViewModel {

    private ProximityRepository proximityRepository;
    private LiveData<List<ProximityData>> listLiveDataProximity;

    public ViewModelProximity(@NonNull Application application) {
        super(application);


        proximityRepository=new ProximityRepository(application);
        listLiveDataProximity=proximityRepository.getListLiveDataProximity();

    }

   public LiveData<List<ProximityData>> getListLiveDataProximity(){
        return listLiveDataProximity;
    }

    public void insert(ProximityData proximityData){

        proximityRepository.insert(proximityData);

    }
}
