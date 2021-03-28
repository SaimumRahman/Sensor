package com.example.the_perfect_room.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Light_Sensor")
public class LightData {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int lightId;

    @ColumnInfo(name = "LightValue")
    private String lightValue;

    @ColumnInfo(name = "date_time")
    private String date_time;


    public LightData(int lightId, @NonNull String lightValue, @NonNull String date_time) {
        this.lightId = lightId;
        this.lightValue = lightValue;
        this.date_time = date_time;

    }

    public int getLightId() {
        return lightId;
    }

    public void setLightId(int lightId) {
        this.lightId = lightId;
    }

    @NonNull
    public String getLightValue() {
        return lightValue;
    }

    public void setLightValue(@NonNull String lightValue) {
        this.lightValue = lightValue;
    }


    @NonNull
    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(@NonNull String date_time) {
        this.date_time = date_time;
    }
}
