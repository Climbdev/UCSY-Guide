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
import com.climbdev2016.ucsyfresherguide.adapters.ScheduleRVAdapter;
import com.climbdev2016.ucsyfresherguide.model.Schedule;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    private RecyclerView scheduleRecyclerView;
    private ScheduleRVAdapter scheduleRVAdapter;
    private List<Schedule> scheduleList = new ArrayList<>();


    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        scheduleRecyclerView = (RecyclerView) view.findViewById(R.id.rv_timetable);
        scheduleRVAdapter = new ScheduleRVAdapter(scheduleList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(view.getContext());
        //disciplineRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        scheduleRecyclerView.setLayoutManager(manager);
        scheduleRecyclerView.setAdapter(scheduleRVAdapter);
        scheduleRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(view.getContext(), scheduleRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        scheduleList.clear();
        prepareScheduleData();
        return view;
    }

    private void prepareScheduleData() {
        String[] data = {
                "Start Time - 8:30AM", "Break Time - 11:10AM to 12:00AM", "End Time - 3:30PM",
                "First Semester - December to March (15 - weeks)", "Exams Period - March to April (Written + Practical)",
                "First Semester Break - April to May (1 - month)", "Second Semester - May to August (17 - weeks)",
                "Exams Period - September (Written + Practical)", "Second Semester Break - September to December (2 - months)"
        };

        int[] icon = { R.drawable.ic_access_time_black_24dp, R.drawable.ic_access_time_black_24dp,
                R.drawable.ic_access_time_black_24dp, R.drawable.ic_date_range_black_24dp,
                R.drawable.ic_date_range_black_24dp, R.drawable.ic_date_range_black_24dp, R.drawable.ic_date_range_black_24dp,
                R.drawable.ic_date_range_black_24dp, R.drawable.ic_date_range_black_24dp,

        };

        for (int i = 0; i<data.length; i++) {
            Schedule schedule = new Schedule(data[i], icon[i]);
            scheduleList.add(schedule);
        }
    }

}
