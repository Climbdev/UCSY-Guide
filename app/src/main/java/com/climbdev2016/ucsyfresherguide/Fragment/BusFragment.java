package com.climbdev2016.ucsyfresherguide.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.climbdev2016.ucsyfresherguide.DividerItemDecoration;
import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.RecyclerTouchListener;
import com.climbdev2016.ucsyfresherguide.adapters.BusRVAdapter;
import com.climbdev2016.ucsyfresherguide.model.Bus;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BusFragment extends Fragment {

    private RecyclerView busRecyclerView;
    private BusRVAdapter busRVAdapter;
    private List<Bus> busList = new ArrayList<>();


    public BusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bus, container, false);

        busRecyclerView = (RecyclerView) view.findViewById(R.id.rv_bus);

        busRVAdapter = new BusRVAdapter(busList);

        busRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        busRecyclerView.setLayoutManager(mLayoutManager);
        busRecyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), LinearLayoutManager.VERTICAL));
        busRecyclerView.setItemAnimator(new DefaultItemAnimator());
        busRecyclerView.setAdapter(busRVAdapter);

        busRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(view.getContext(), busRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareData();

        return view;

    }

    private void prepareData() {

        Bus bus;

        String[] busData = getResources().getStringArray(R.array.bus_list);
        String [] id = {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"
        };

        for ( int i = 0; i<busData.length; i++) {
            bus = new Bus(id[i], busData[i]);
            busList.add(bus);

        }
    }

}
