package com.example.the_perfect_room.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.the_perfect_room.Model.LightData;
import com.example.the_perfect_room.databinding.LightViewBinding;

import java.util.List;

public class AdapterLight extends RecyclerView.Adapter<AdapterLight.ViewHolder> {

    private Context context;
    private List<LightData> lightDataList;

    public AdapterLight(Context context) {
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LightViewBinding lightViewBinding = LightViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(lightViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (lightDataList != null) {
            LightData data = lightDataList.get(position);
            holder.lightViewBindings.lightValue.setText(data.getLightValue());
            holder.lightViewBindings.dateTime.setText(data.getDate_time());
        } else {
            holder.lightViewBindings.lightValue.setText("No Data");
        }
    }

   public void setLightDataList(List<LightData> lightDataLists) {
        lightDataList = lightDataLists;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        if (lightDataList != null) {
            return lightDataList.size();
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
