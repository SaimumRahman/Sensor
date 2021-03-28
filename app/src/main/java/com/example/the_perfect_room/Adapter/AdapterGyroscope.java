package com.example.the_perfect_room.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.the_perfect_room.Model.AccelerometerData;
import com.example.the_perfect_room.Model.GyroscopeData;
import com.example.the_perfect_room.databinding.AccelerometerGyroscopeViewBinding;

import java.util.List;

public class AdapterGyroscope extends RecyclerView.Adapter<AdapterGyroscope.ViewHolder> {

    private Context context;
    private List<GyroscopeData> gyroscopeDataList;

    public AdapterGyroscope(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterGyroscope.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AccelerometerGyroscopeViewBinding viewBinding=AccelerometerGyroscopeViewBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(viewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGyroscope.ViewHolder holder, int position) {
        if (gyroscopeDataList!=null){
            GyroscopeData gyroscopeData=gyroscopeDataList.get(position);
            holder.accelerometerGyroscopeViewBinding.gyroAcceleroValue1.setText(gyroscopeData.getGyroscope_valueX());
            holder.accelerometerGyroscopeViewBinding.gyroAcceleroValue2.setText(gyroscopeData.getGyroscope_valueY());
            holder.accelerometerGyroscopeViewBinding.gyroAcceleroValue3.setText(gyroscopeData.getGyroscope_valueZ());
        }else {
            holder.accelerometerGyroscopeViewBinding.gyroAcceleroValue1.setText("No Data");
            holder.accelerometerGyroscopeViewBinding.gyroAcceleroValue2.setText("No Data");
            holder.accelerometerGyroscopeViewBinding.gyroAcceleroValue3.setText("No Data");
        }
    }
    public void setGyroscopeData(List<GyroscopeData> gyroscopeData) {
        gyroscopeDataList = gyroscopeData;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if (gyroscopeDataList!=null){
           return gyroscopeDataList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private AccelerometerGyroscopeViewBinding accelerometerGyroscopeViewBinding;
        public ViewHolder(@NonNull AccelerometerGyroscopeViewBinding itemView) {
            super(itemView.getRoot());
            accelerometerGyroscopeViewBinding=itemView;
        }
    }
}
