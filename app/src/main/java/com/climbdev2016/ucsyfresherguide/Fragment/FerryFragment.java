package com.climbdev2016.ucsyfresherguide.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.RecyclerTouchListener;
import com.climbdev2016.ucsyfresherguide.activities.FerryDatailActivity;
import com.climbdev2016.ucsyfresherguide.adapters.TransRVAdapter;
import com.climbdev2016.ucsyfresherguide.model.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FerryFragment extends Fragment {

    private List<Data> dataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TransRVAdapter transRVAdapter;


    public FerryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ferry, container, false);

        final String[] titles = view.getResources().getStringArray(R.array.ferry_list);
        final String[] contacts = view.getResources().getStringArray(R.array.contact);
        final String[] places = view.getResources().getStringArray(R.array.place);

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_ferry_list);

        transRVAdapter = new TransRVAdapter(dataList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(transRVAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(view.getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent intent = new Intent(view.getContext(), FerryDatailActivity.class);
                intent.putExtra("title", titles[position]);
                intent.putExtra("place", places[position]);
                intent.putExtra("contact", contacts[position]);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareData();
        return view;
    }

    private void prepareData() {

        String[] places = getResources().getStringArray(R.array.ferry_list);

        Data data;

        for ( int i = 0; i<places.length; i++) {
            data = new Data(places[i]);
            dataList.add(data);
        }
    }

}
