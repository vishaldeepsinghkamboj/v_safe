package com.example.vishaldeepsingh.vsafe.Fragment;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import com.example.vishaldeepsingh.vsafe.Activity.MainActivity;
import com.example.vishaldeepsingh.vsafe.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
  ToggleButton dangerButton;
    MediaPlayer mp;



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View view=  inflater.inflate(R.layout.fragment_home, container, false);
        mp=MediaPlayer.create(getActivity(),R.raw.alert);

        dangerButton=(ToggleButton)view.findViewById(R.id.dangerButton);
       dangerButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked)
               {
                   mp.start();
               }
               else
               {
                   mp.pause();
               }
           }
       });

        return view;

    }

}
