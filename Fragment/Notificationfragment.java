package com.example.vishaldeepsingh.vsafe.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vishaldeepsingh.vsafe.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Notificationfragment extends Fragment {


    public Notificationfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notificationfragment, container, false);
    }

}
