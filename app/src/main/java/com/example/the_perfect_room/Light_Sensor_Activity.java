package com.example.the_perfect_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import com.example.the_perfect_room.Adapter.AdapterLight;
import com.example.the_perfect_room.Database.RoomDatabase;
import com.example.the_perfect_room.Model.LightData;
import com.example.the_perfect_room.ViewModel.ViewModelLightSensor;
import com.example.the_perfect_room.databinding.ActivityMainBinding;
import com.example.the_perfect_room.databinding.ActivitySensorBinding;

import java.util.List;

public class Light_Sensor_Activity extends AppCompatActivity{

    private ActivitySensorBinding sensorBinding;
    private AdapterLight adapterLight;
    private ViewModelLightSensor viewModelLightSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sensorBinding=ActivitySensorBinding.inflate(getLayoutInflater());
        setContentView(sensorBinding.getRoot());

        viewModelLightSensor = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(ViewModelLightSensor.class);

        sensorBinding.sensorName.setText("Light Data");
        adapterLight=new AdapterLight(this);
        sensorBinding.lightSensorRecycler.setLayoutManager(new LinearLayoutManager(this));
        sensorBinding.lightSensorRecycler.setAdapter(adapterLight);
        adapterLight.notifyDataSetChanged();

        viewModelLightSensor.getListLiveDataRepo().observe(this, lightData -> {
            if (lightData!=null){
                adapterLight.setLightDataList(lightData);
                adapterLight.notifyDataSetChanged();
            }

        });



    }


}