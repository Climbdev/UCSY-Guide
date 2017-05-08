package com.climbdev2016.ucsyfresherguide.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.RecyclerTouchListener;
import com.climbdev2016.ucsyfresherguide.adapters.DisplineRVAdapter;
import com.climbdev2016.ucsyfresherguide.model.Discipline;

import java.util.ArrayList;
import java.util.List;

public class DisciplineFragment extends Fragment {

    private RecyclerView disciplineRecyclerView;
    private DisplineRVAdapter displineRVAdapter;
    private List<Discipline> disciplineList = new ArrayList<>();


    public DisciplineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discipline, container, false);

        disciplineRecyclerView = (RecyclerView) view.findViewById(R.id.rvDis);
        displineRVAdapter = new DisplineRVAdapter(disciplineList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(view.getContext());
        //disciplineRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        disciplineRecyclerView.setLayoutManager(manager);
        disciplineRecyclerView.setAdapter(displineRVAdapter);
        disciplineRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(view.getContext(), disciplineRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        prepareDisciplineData();

        return view;
    }

    private void prepareDisciplineData() {
        String[] titles = getResources().getStringArray(R.array.discipline_item);
        String[] no = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
        "11", "12", "13", "14", "15", "16"};

        for (int i = 0; i<titles.length;i++){
            Discipline rec = new Discipline(no[i], titles[i]);
            disciplineList.add(rec);
        }
    }

}
