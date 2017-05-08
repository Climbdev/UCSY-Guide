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
import com.climbdev2016.ucsyfresherguide.model.DepartmentModel;

import java.util.List;

/**
 * Created by zwe on 11/29/16.
 */

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.ViewHolder> {

    Context context;
    List<DepartmentModel> departmentList ;

    public DepartmentAdapter(Context context , List<DepartmentModel> departmentList){
        this.context = context;
        this.departmentList = departmentList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.department_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.dtitle.setText(departmentList.get(position).getTitle());
        Glide.with(context).load(departmentList.get(position).getImage())
                .thumbnail(0.5f)
                .override(200, 200)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.error)
                .into(holder.dimage);

    }

    @Override
    public int getItemCount() {
        return departmentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView dimage;
        private TextView dtitle;

        public ViewHolder(View itemView) {
            super(itemView);
            dimage = (ImageView) itemView.findViewById(R.id.dep_image);
            dtitle = (TextView) itemView.findViewById(R.id.dep_title);
        }
    }
}
