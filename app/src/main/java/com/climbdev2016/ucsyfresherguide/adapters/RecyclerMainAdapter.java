package com.climbdev2016.ucsyfresherguide.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.model.MainModel;

import java.util.List;

/**
 * Created by zwe on 11/21/16.
 */

public class RecyclerMainAdapter extends RecyclerView.Adapter<RecyclerMainAdapter.ViewHolder> {

    private Context context;
    private List<MainModel> mainList;
    OnItemClickListener itemClickListener;


    public RecyclerMainAdapter(Context context , List<MainModel> mainList){
        this.context = context;
        this.mainList = mainList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.main_item,parent,false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mtitle.setText(mainList.get(position).getTitles());
        holder.mimage.setImageResource(mainList.get(position).getImages());
        //Glide.with(context).load(mainList.get(position).getImages()).into(holder.mimage);

    }

    @Override
    public int getItemCount() {
        return mainList.size();
    }


    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemCLickListener(final OnItemClickListener itemCLickListener){
        this.itemClickListener = itemCLickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mtitle;
        public ImageView mimage;

        public ViewHolder(View itemView) {
            super(itemView);
            mtitle = (TextView) itemView.findViewById(R.id.tv_main);
            mimage = (ImageView) itemView.findViewById(R.id.iv_main);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null){
                itemClickListener.onItemClick(v,getAdapterPosition());
            }
        }
    }
}
