package com.example.the_perfect_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.the_perfect_room.Adapter.AdapterGyroscope;
import com.example.the_perfect_room.Adapter.AdapterProximity;
import com.example.the_perfect_room.ViewModel.ViewModelGyroscope;
import com.example.the_perfect_room.ViewModel.ViewModelProximity;
import com.example.the_perfect_room.databinding.ActivityGyroscopeBinding;

public class Gyroscope_Activity extends AppCompatActivity {

    private ActivityGyroscopeBinding gyroscopeBinding;
    private AdapterGyroscope adapterGyroscope;
    private ViewModelGyroscope viewModelGyroscope;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gyroscopeBinding=ActivityGyroscopeBinding.inflate(getLayoutInflater());
        setContentView(gyroscopeBinding.getRoot());

        gyroscopeBinding.sensorName.setText("Gyroscope Data");

        viewModelGyroscope = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(ViewModelGyroscope.class);


        adapterGyroscope=new AdapterGyroscope(this);
        gyroscopeBinding.gyroscopeSensorRecycler.setLayoutManager(new LinearLayoutManager(this));
        gyroscopeBinding.gyroscopeSensorRecycler.setAdapter(adapterGyroscope);
        adapterGyroscope.notifyDataSetChanged();

        viewModelGyroscope.getListLiveDataGyroscope().observe(this, gyroscopeData -> {
            if (gyroscopeData!=null){
                adapterGyroscope.setGyroscopeData(gyroscopeData);
                adapterGyroscope.notifyDataSetChanged();
            }

        });

    }
}