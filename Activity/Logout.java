package com.example.vishaldeepsingh.vsafe.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Vishaldeep Singh on 26-Sep-16.
 */

public class Logout extends Activity{
    @Override
    protected void onPause() {
        super.onPause();
       finish();
        
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }
}
