package com.example.the_perfect_room.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.the_perfect_room.Model.LightData;
import com.example.the_perfect_room.Model.ProximityData;
import com.example.the_perfect_room.databinding.LightViewBinding;

import java.util.List;


public class AdapterProximity extends RecyclerView.Adapter<AdapterProximity.ViewHolder> {

    private Context context;
    private List<ProximityData> proximityData;

    public AdapterProximity(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterProximity.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LightViewBinding lightViewBinding = LightViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(lightViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProximity.ViewHolder holder, int position) {
        if (proximityData != null) {
            ProximityData data = proximityData.get(position);
            holder.lightViewBindings.lightValue.setText(data.getProximityValue());
            holder.lightViewBindings.dateTime.setText(data.getDate_time());
        } else {
            holder.lightViewBindings.lightValue.setText("No Data");
        }
    }
    public void setProximityData(List<ProximityData> proximityDatas) {
        proximityData = proximityDatas;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (proximityData != null) {
            return proximityData.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LightViewBinding lightViewBindings;
        public ViewHolder(@NonNull LightViewBinding itemView) {
            super(itemView.getRoot());
            lightViewBindings = itemView;
        }
    }
}

