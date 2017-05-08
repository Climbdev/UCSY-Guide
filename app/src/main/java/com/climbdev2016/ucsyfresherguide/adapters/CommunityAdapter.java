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
import com.climbdev2016.ucsyfresherguide.model.CommunityModel;

import java.util.List;

/**
 * Created by zwe on 11/21/16.
 */

public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.ViewHolder>{

    private Context context;
    private List<CommunityModel> communityList;
    private OnItemClickListener itemClickListener;

    public CommunityAdapter(Context context, List<CommunityModel> communityList){
        this.context = context;
        this.communityList = communityList;
    }


    @Override
    public CommunityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.community_item,parent,false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(CommunityAdapter.ViewHolder holder, int position) {
        holder.title.setText(communityList.get(position).getTitle());
        Glide.with(context).load(communityList.get(position).getImages()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return communityList.size();
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_community);
            image = (ImageView) itemView.findViewById(R.id.iv_community);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(itemClickListener!=null){
                itemClickListener.onItemClick(v,getAdapterPosition());
            }
        }
    }
}
