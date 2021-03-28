package com.example.the_perfect_room.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Gyroscope_table")
public class GyroscopeData {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Gyroscope_id")
    private int id;

    @ColumnInfo(name = "gyroscope_valueX")
    private String gyroscope_valueX;

    @ColumnInfo(name = "gyroscope_valueY")
    private String gyroscope_valueY;

    @ColumnInfo(name = "gyroscope_valueZ")
    private String gyroscope_valueZ;

    @ColumnInfo(name = "date_time")
    private String date_time;

    public GyroscopeData(int id, String gyroscope_valueX, String gyroscope_valueY, String gyroscope_valueZ, String date_time) {
        this.id = id;
        this.gyroscope_valueX = gyroscope_valueX;
        this.gyroscope_valueY = gyroscope_valueY;
        this.gyroscope_valueZ = gyroscope_valueZ;
        this.date_time = date_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGyroscope_valueX() {
        return gyroscope_valueX;
    }

    public void setGyroscope_valueX(String gyroscope_valueX) {
        this.gyroscope_valueX = gyroscope_valueX;
    }

    public String getGyroscope_valueY() {
        return gyroscope_valueY;
    }

    public void setGyroscope_valueY(String gyroscope_valueY) {
        this.gyroscope_valueY = gyroscope_valueY;
    }

    public String getGyroscope_valueZ() {
        return gyroscope_valueZ;
    }

    public void setGyroscope_valueZ(String gyroscope_valueZ) {
        this.gyroscope_valueZ = gyroscope_valueZ;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}
