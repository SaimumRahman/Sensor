package com.example.the_perfect_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.the_perfect_room.Adapter.AdapterLight;
import com.example.the_perfect_room.Adapter.AdapterProximity;
import com.example.the_perfect_room.Model.ProximityData;
import com.example.the_perfect_room.ViewModel.ViewModelLightSensor;
import com.example.the_perfect_room.ViewModel.ViewModelProximity;
import com.example.the_perfect_room.databinding.ActivityProximitySensorBinding;

import java.util.List;

public class Proximity_Sensor_Activity extends AppCompatActivity {

    private ActivityProximitySensorBinding proximitySensorBinding;
    private AdapterProximity adapterProximity;
    private ViewModelProximity proximityModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        proximitySensorBinding=ActivityProximitySensorBinding.inflate(getLayoutInflater());
        setContentView(proximitySensorBinding.getRoot());


        proximitySensorBinding.sensorName.setText("Proximity Data");

        proximityModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(ViewModelProximity.class);

        proximitySensorBinding.sensorName.setText("Proximity Data");
        adapterProximity=new AdapterProximity(this);
        proximitySensorBinding.proximitySensorRecycler.setLayoutManager(new LinearLayoutManager(this));
        proximitySensorBinding.proximitySensorRecycler.setAdapter(adapterProximity);
        adapterProximity.notifyDataSetChanged();

        proximityModel.getListLiveDataProximity().observe(this, proximityData -> {
            if (proximityData!=null){
                adapterProximity.setProximityData(proximityData);
                adapterProximity.notifyDataSetChanged();
            }

        });





    }

}