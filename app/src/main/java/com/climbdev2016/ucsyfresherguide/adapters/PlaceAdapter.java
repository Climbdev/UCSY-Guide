package com.climbdev2016.ucsyfresherguide.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.activities.Places;
import com.climbdev2016.ucsyfresherguide.model.PlacesModel;

import java.util.List;

/**
 * Created by zwe on 11/28/16.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder>{

    Context context;
    List<PlacesModel> placesList;


    public PlaceAdapter(Context context , List<PlacesModel> placesList){
        this.context = context;
        this.placesList = placesList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.places_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.pimage.setImageResource(placesList.get(position).getImage());
        holder.ptitle.setText(placesList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return placesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pimage;
        TextView ptitle;

        public ViewHolder(View view) {
            super(view);
            pimage = (ImageView) view.findViewById(R.id.singleRowImagePlaces);
            ptitle = (TextView) view.findViewById(R.id.singleRowTextPlaces);
        }
    }
}
