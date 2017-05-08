package com.climbdev2016.ucsyfresherguide.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.model.Data;

import java.util.List;

public class TransRVAdapter extends RecyclerView.Adapter<TransRVAdapter.MyViewHolder> {

    private List<Data> dataList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //public TextView organizerName;
        public TextView mhatTine;

        public MyViewHolder(View view) {
            super(view);
            //organizerName = (TextView) view.findViewById(R.id.organizer_name);
            mhatTine = (TextView) view.findViewById(R.id.ferry_mt);
        }
    }


    public TransRVAdapter(List<Data> dataList) {
        this.dataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ferry_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Data data = dataList.get(position);
        //holder.organizerName.setText(data.getOrganizerName());
        holder.mhatTine.setText(data.getPlaces());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
