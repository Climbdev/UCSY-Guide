package com.climbdev2016.ucsyfresherguide.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.model.GalleryModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zwe on 11/25/16.
 */

public class GalleryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<GalleryModel> data = new ArrayList<>();

    public GalleryAdapter(Context context, List<GalleryModel> data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item, parent, false);
        viewHolder = new MyItemHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).getUrl())
                .thumbnail(0.5f)
                .override(200, 200)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.error)
                .into(((MyItemHolder) holder).mImg);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyItemHolder extends RecyclerView.ViewHolder {
        ImageView mImg;


        public MyItemHolder(View itemView) {
            super(itemView);

            mImg = (ImageView) itemView.findViewById(R.id.item_img);
        }

    }
}
