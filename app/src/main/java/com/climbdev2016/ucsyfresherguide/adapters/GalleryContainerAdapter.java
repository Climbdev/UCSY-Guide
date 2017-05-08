package com.climbdev2016.ucsyfresherguide.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.model.GalleryContainerModel;

import java.util.List;

/**
 * Created by zwe on 12/1/16.
 */

public class GalleryContainerAdapter  extends RecyclerView.Adapter<GalleryContainerAdapter.ViewHolder>{

    private Context context;
    private List<GalleryContainerModel> gcList;

    public GalleryContainerAdapter(Context context, List<GalleryContainerModel> gcList){
        this.context = context;
        this.gcList = gcList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gallery_container_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(gcList.get(position).getImage())
                .thumbnail(0.5f)
                .override(200, 200)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.error).into(holder.gcImage);
        holder.gcTitle.setText(gcList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return gcList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView gcImage;
        private TextView gcTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            gcImage = (ImageView) itemView.findViewById(R.id.iv_gallery_container);
            gcTitle = (TextView) itemView.findViewById(R.id.tv_gallery_container);
        }
    }
}
