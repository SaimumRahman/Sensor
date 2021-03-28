package com.example.the_perfect_room;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;

import com.example.the_perfect_room.Model.AccelerometerData;
import com.example.the_perfect_room.Model.GyroscopeData;
import com.example.the_perfect_room.Model.LightData;
import com.example.the_perfect_room.Model.ProximityData;
import com.example.the_perfect_room.ViewModel.ViewModelAccelerometer;
import com.example.the_perfect_room.ViewModel.ViewModelGyroscope;
import com.example.the_perfect_room.ViewModel.ViewModelLightSensor;
import com.example.the_perfect_room.ViewModel.ViewModelProximity;
import com.example.the_perfect_room.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.security.Provider;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private ActivityMainBinding mainBinding;
    private ViewModelLightSensor viewModelLightSensor;
    private ViewModelProximity viewModelProximity;
    private ViewModelAccelerometer viewModelAccelerometer;
    private ViewModelGyroscope viewModelGyroscope;
    private Sensor lightSensor, gyroscopeSensor, proximitySensor, accelerometerSensor;
    private SensorManager sensorManager;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mainBinding.lightSensor.setText(String.valueOf(0));
        mainBinding.proximitySensor.setText(String.valueOf(0));

        viewModelLightSensor = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(ViewModelLightSensor.class);
        viewModelProximity = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(ViewModelProximity.class);
        viewModelAccelerometer = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(ViewModelAccelerometer.class);
        viewModelGyroscope = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(ViewModelGyroscope.class);


        databaseTransaction();




        mainBinding.lightCard.setOnClickListener(v ->{
            startActivity(new Intent(MainActivity.this, Light_Sensor_Activity.class));
        });
        mainBinding.proximityCard.setOnClickListener(v ->{
            startActivity(new Intent(MainActivity.this, Proximity_Sensor_Activity.class));
        });
        mainBinding.accelerometerCard.setOnClickListener(v ->{
            startActivity(new Intent(MainActivity.this, Accelerometer_Activity.class));
        });
        mainBinding.gyroscopeCard.setOnClickListener(v ->{
            startActivity(new Intent(MainActivity.this, Gyroscope_Activity.class));
        });

    }

    public void databaseTransaction() {
        count++;
        getSensorData();

        refresh(100000);
    }

    private void refresh(int milliseconds) {
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                databaseTransaction();
            }
        };
        handler.postDelayed(runnable, milliseconds);
    }

    private void getSensorData() {

        String light = mainBinding.lightSensor.getText().toString();
        String proximity = mainBinding.proximitySensor.getText().toString();
        String acceleratorX = mainBinding.accelerometer1.getText().toString();
        String acceleratorY = mainBinding.accelerometer2.getText().toString();
        String acceleratorZ = mainBinding.accelerometer3.getText().toString();
        String gyroscopeX = mainBinding.gyroscope1.getText().toString();
        String gyroscopeY = mainBinding.gyroscope2.getText().toString();
        String gyroscopeZ = mainBinding.gyroscope3.getText().toString();

        LightData lightData = new LightData(0, light, String.valueOf(Calendar.getInstance().getTime()));
        viewModelLightSensor.insert(lightData);

        ProximityData proximityData = new ProximityData(0, proximity, String.valueOf(Calendar.getInstance().getTime()));
        viewModelProximity.insert(proximityData);

        AccelerometerData accelerometerData = new AccelerometerData(0, acceleratorX, acceleratorY, acceleratorZ, String.valueOf(Calendar.getInstance().getTime()));
        viewModelAccelerometer.insert(accelerometerData);

        GyroscopeData gyroscopeData = new GyroscopeData(0, gyroscopeX, gyroscopeY, gyroscopeZ, String.valueOf(Calendar.getInstance().getTime()));
        viewModelGyroscope.insert(gyroscopeData);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (lightSensor != null) {
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (proximitySensor != null) {
            sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (accelerometerSensor != null) {
            sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (gyroscopeSensor != null) {
            sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        int sensorType = event.sensor.getType();

        switch (sensorType) {

            case Sensor.TYPE_LIGHT:

                float lightValue = event.values[0];
                mainBinding.lightSensor.setText(String.valueOf(lightValue));

                break;

            case Sensor.TYPE_ACCELEROMETER:

                float accelerometerValueX = event.values[0];
                mainBinding.accelerometer1.setText(String.valueOf(accelerometerValueX));

                float accelerometerValueY = event.values[1];
                mainBinding.accelerometer2.setText(String.valueOf(accelerometerValueY));

                float accelerometerValueZ = event.values[2];
                mainBinding.accelerometer3.setText(String.valueOf(accelerometerValueZ));

                break;
            case Sensor.TYPE_GYROSCOPE:

                float gyroscopeValueX = event.values[0];
                mainBinding.gyroscope1.setText(String.valueOf(gyroscopeValueX));

                float gyroscopeValueY = event.values[1];
                mainBinding.gyroscope2.setText(String.valueOf(gyroscopeValueY));

                float gyroscopeValueZ = event.values[2];
                mainBinding.gyroscope3.setText(String.valueOf(gyroscopeValueZ));
                break;

            case Sensor.TYPE_PROXIMITY:

                float proximityValue = event.values[0];
                mainBinding.proximitySensor.setText(String.valueOf(proximityValue));

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}