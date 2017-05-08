package com.climbdev2016.ucsyfresherguide.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.climbdev2016.ucsyfresherguide.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Uniform extends Fragment {


    public Uniform() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_uniform, container, false);
    }

}
