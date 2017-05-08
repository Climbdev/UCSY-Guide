package com.climbdev2016.ucsyfresherguide.Fragment;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.climbdev2016.ucsyfresherguide.GridSpacingItemDecoration;
import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.adapters.TrainAdapter;
import com.climbdev2016.ucsyfresherguide.model.Train;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrainFragment extends Fragment {

    private RecyclerView recyclerView;
    private TrainAdapter trainAdapter;
    private List<Train> trainList;


    public TrainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_train, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_train);

        trainList = new ArrayList<>();
        trainAdapter = new TrainAdapter(view.getContext(), trainList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(view.getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(8), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(trainAdapter);

        prepareData();


        return view;
    }

    private void prepareData() {

        Train train;

        String[] butars = getResources().getStringArray(R.array.butar_name);
        String[] toUcsy = getResources().getStringArray(R.array.to_ucsy);
        String[] fromUcsy = getResources().getStringArray(R.array.from_ucsy);

        for(int i=0; i<butars.length; i++) {
            train = new Train(butars[i], toUcsy[i], fromUcsy[i]);
            trainList.add(train);
        }

        trainAdapter.notifyDataSetChanged();
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
