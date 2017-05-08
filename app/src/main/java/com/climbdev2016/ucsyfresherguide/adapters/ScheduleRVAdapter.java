package com.climbdev2016.ucsyfresherguide.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.model.Schedule;

import java.util.List;


/**
 * Created by Myo Lwin Oo on 11/23/2016.
 */

public class ScheduleRVAdapter extends RecyclerView.Adapter<ScheduleRVAdapter.MyViewHolder> {

    private List<Schedule> scheduleList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView data;
        ImageView icon;

        public MyViewHolder(View view) {
            super(view);
            data = (TextView) view.findViewById(R.id.data_time);
            icon = (ImageView) view.findViewById(R.id.icon_time);
        }
    }


    public ScheduleRVAdapter(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Schedule data = scheduleList.get(position);
        holder.data.setText(data.getData());
        holder.icon.setImageResource(data.getIcon());
    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }
}
