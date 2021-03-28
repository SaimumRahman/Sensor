package com.example.the_perfect_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.the_perfect_room.Adapter.AdapterAccelerometer;
import com.example.the_perfect_room.Adapter.AdapterProximity;
import com.example.the_perfect_room.Model.AccelerometerData;
import com.example.the_perfect_room.ViewModel.ViewModelAccelerometer;
import com.example.the_perfect_room.ViewModel.ViewModelProximity;
import com.example.the_perfect_room.databinding.ActivityAccelerometerBinding;

import java.util.List;

public class Accelerometer_Activity extends AppCompatActivity {
private ActivityAccelerometerBinding activityAccelerometerBinding;
private AdapterAccelerometer adapterAccelerometer;
private ViewModelAccelerometer viewModelAccelerometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
activityAccelerometerBinding=ActivityAccelerometerBinding.inflate(getLayoutInflater());
        setContentView(activityAccelerometerBinding.getRoot());

        activityAccelerometerBinding.sensorName.setText("Accelerometer Data");

        viewModelAccelerometer = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(ViewModelAccelerometer.class);


        adapterAccelerometer=new AdapterAccelerometer(this);
        activityAccelerometerBinding.accelerometerSensorRecycler.setLayoutManager(new LinearLayoutManager(this));
        activityAccelerometerBinding.accelerometerSensorRecycler.setAdapter(adapterAccelerometer);
        adapterAccelerometer.notifyDataSetChanged();

    viewModelAccelerometer.getLiveDataAccelerometer().observe(this, accelerometerData -> {
        if (accelerometerData!=null){
            adapterAccelerometer.setAccelerometerData(accelerometerData);
            adapterAccelerometer.notifyDataSetChanged();
        }
    });
    }
}