package com.example.the_perfect_room.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Proximity_Sensor")
public class ProximityData {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int proximityId;


    @ColumnInfo(name = "ProximityValue")
    private String proximityValue;


    @ColumnInfo(name = "date_time")
    private String date_time;


    public ProximityData(int proximityId, @NonNull String proximityValue, @NonNull String date_time) {
        this.proximityId = proximityId;
        this.proximityValue = proximityValue;
        this.date_time = date_time;
    }

    public int getProximityId() {
        return proximityId;
    }

    public void setProximityId(int proximityId) {
        this.proximityId = proximityId;
    }

    @NonNull
    public String getProximityValue() {
        return proximityValue;
    }

    public void setProximityValue(@NonNull String proximityValue) {
        this.proximityValue = proximityValue;
    }

    @NonNull
    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(@NonNull String date_time) {
        this.date_time = date_time;
    }
}
