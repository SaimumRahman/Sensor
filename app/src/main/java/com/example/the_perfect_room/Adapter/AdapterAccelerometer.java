package com.example.the_perfect_room.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.the_perfect_room.Model.AccelerometerData;
import com.example.the_perfect_room.Model.ProximityData;
import com.example.the_perfect_room.databinding.AccelerometerGyroscopeViewBinding;

import java.util.List;

public class AdapterAccelerometer extends RecyclerView.Adapter<AdapterAccelerometer.ViewHolder> {

    private Context context;
    private List<AccelerometerData> accelerometerDataList;

    public AdapterAccelerometer(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterAccelerometer.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AccelerometerGyroscopeViewBinding viewBinding=AccelerometerGyroscopeViewBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(viewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAccelerometer.ViewHolder holder, int position) {
        if (accelerometerDataList!=null){
            AccelerometerData accelerometerData=accelerometerDataList.get(position);
            holder.accelerometerGyroscopeViewBinding.gyroAcceleroValue1.setText(accelerometerData.getAccelerometer_valueX());
            holder.accelerometerGyroscopeViewBinding.gyroAcceleroValue2.setText(accelerometerData.getAccelerometer_valueY());
            holder.accelerometerGyroscopeViewBinding.gyroAcceleroValue3.setText(accelerometerData.getAccelerometer_valueZ());
        }else {
            holder.accelerometerGyroscopeViewBinding.gyroAcceleroValue1.setText("No Data");
            holder.accelerometerGyroscopeViewBinding.gyroAcceleroValue2.setText("No Data");
            holder.accelerometerGyroscopeViewBinding.gyroAcceleroValue3.setText("No Data");
        }

    }
    public void setAccelerometerData(List<AccelerometerData> accelerometerDatas) {
        accelerometerDataList = accelerometerDatas;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (accelerometerDataList != null) {
            return accelerometerDataList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private AccelerometerGyroscopeViewBinding accelerometerGyroscopeViewBinding;
        public ViewHolder(@NonNull AccelerometerGyroscopeViewBinding itemView) {
            super(itemView.getRoot());
            accelerometerGyroscopeViewBinding=itemView;
        }
    }
}
