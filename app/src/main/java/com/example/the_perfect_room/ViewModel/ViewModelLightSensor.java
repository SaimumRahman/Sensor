package com.example.the_perfect_room.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.the_perfect_room.Model.LightData;
import com.example.the_perfect_room.Repository.LightRepository;

import java.util.List;

public class ViewModelLightSensor extends AndroidViewModel {

    private LightRepository repository;
    private LiveData<List<LightData>> listLiveDataRepo;

    public ViewModelLightSensor(@NonNull Application application) {
        super(application);

        repository=new LightRepository(application);
        listLiveDataRepo=repository.getLightDataLive();

    }

   public LiveData<List<LightData>> getListLiveDataRepo(){
        return listLiveDataRepo;
    }

    public void insert(LightData data){
        repository.insert(data);
    }
}
