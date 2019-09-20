package com.example.vishaldeepsingh.vsafe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vishaldeepsingh.vsafe.R;

public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        onPause();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
