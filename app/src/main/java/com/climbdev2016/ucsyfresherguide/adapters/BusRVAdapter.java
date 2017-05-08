package com.climbdev2016.ucsyfresherguide.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.model.Bus;

import java.util.List;

/**
 * Created by Myo Lwin Oo on 11/29/2016.
 */

public class BusRVAdapter extends RecyclerView.Adapter<BusRVAdapter.MyViewHolder>{

    List<Bus> busList;

    public BusRVAdapter(List<Bus> busList) {
        this.busList = busList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bus_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Bus bus = busList.get(position);
        holder.bus_id.setText(bus.getId());
        holder.bus_data.setText(bus.getData());
    }

    @Override
    public int getItemCount() {
        return busList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView bus_id;
        public TextView bus_data;

        public MyViewHolder(View view) {
            super(view);
            bus_id = (TextView) view.findViewById(R.id.list_id);
            bus_data = (TextView) view.findViewById(R.id.list_data);
        }
    }
}
