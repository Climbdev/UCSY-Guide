package com.climbdev2016.ucsyfresherguide.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.model.Train;

import java.util.List;

/**
 * Created by Myo Lwin Oo on 11/29/2016.
 */

public class TrainAdapter extends RecyclerView.Adapter<TrainAdapter.ViewHolder> {

    private Context mContext;
    private List<Train> trainList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.train_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Train train = trainList.get(position);
        holder.buTar.setText(train.getBuTar());
        holder.from.setText(train.getFrom());
        holder.to.setText(train.getTo());
    }

    @Override
    public int getItemCount() {
        return trainList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView buTar, from, to;

        public ViewHolder(View view) {
            super(view);
            buTar = (TextView) view.findViewById(R.id.buutar);
            from = (TextView) view.findViewById(R.id.time_one);
            to = (TextView) view.findViewById(R.id.time_two);
        }
    }

    public TrainAdapter(Context mContext, List<Train> trainList) {
        this.mContext = mContext;
        this.trainList = trainList;
    }
}
