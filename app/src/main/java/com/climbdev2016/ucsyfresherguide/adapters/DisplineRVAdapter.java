package com.climbdev2016.ucsyfresherguide.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.model.Discipline;

import java.util.List;


public class DisplineRVAdapter extends RecyclerView.Adapter<DisplineRVAdapter.MyViewHolder> {

    private List<Discipline> dataList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView id, title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.rec_title);
            id = (TextView) view.findViewById(R.id.rec_id);
        }
    }


    public DisplineRVAdapter(List<Discipline> dataList) {
        this.dataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.displine_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Discipline data = dataList.get(position);
        holder.title.setText(data.getTitle());
        holder.id.setText(data.getId());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
