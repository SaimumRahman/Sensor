package com.example.the_perfect_room.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Accelerometer_Sensor")
public class AccelerometerData {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "accelerometer_id")
    private int id;

    @ColumnInfo(name = "accelerometer_valueX")
    private String accelerometer_valueX;

    @ColumnInfo(name = "accelerometer_valueY")
    private String accelerometer_valueY;

    @ColumnInfo(name = "accelerometer_valueZ")
    private String accelerometer_valueZ;

    @ColumnInfo(name = "date_time")
    private String date_time;

    public AccelerometerData(int id, String accelerometer_valueX, String accelerometer_valueY, String accelerometer_valueZ, String date_time) {
        this.id = id;
        this.accelerometer_valueX = accelerometer_valueX;
        this.accelerometer_valueY = accelerometer_valueY;
        this.accelerometer_valueZ = accelerometer_valueZ;
        this.date_time = date_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccelerometer_valueX() {
        return accelerometer_valueX;
    }

    public void setAccelerometer_valueX(String accelerometer_valueX) {
        this.accelerometer_valueX = accelerometer_valueX;
    }

    public String getAccelerometer_valueY() {
        return accelerometer_valueY;
    }

    public void setAccelerometer_valueY(String accelerometer_valueY) {
        this.accelerometer_valueY = accelerometer_valueY;
    }

    public String getAccelerometer_valueZ() {
        return accelerometer_valueZ;
    }

    public void setAccelerometer_valueZ(String accelerometer_valueZ) {
        this.accelerometer_valueZ = accelerometer_valueZ;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}
