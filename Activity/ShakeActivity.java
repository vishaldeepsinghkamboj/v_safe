package com.example.vishaldeepsingh.vsafe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.vishaldeepsingh.vsafe.R;

public class ShakeActivity extends AppCompatActivity implements AccelerometerListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        Toast.makeText(getApplicationContext(), "Shake ur phone", Toast.LENGTH_SHORT).show();
        if (AccelerometerManager.isSupported(this))
        {
            AccelerometerManager.startListening(this);
            Log.i("myMsg"," start ShakeActivity ");
    }
}

    @Override
    public void onAccelerationChanged(float x, float y, float z) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onShake(float force) {
        // TODO Auto-generated method stub
        // Do your stuff here
        Toast.makeText(getBaseContext(), "shake detected",
                Toast.LENGTH_SHORT).show();
        finish();
        Log.i("myMsg"," start BroadcastActivity ");
        Intent i=new Intent(ShakeActivity.this,BroadCastSMS.class);
        startActivity(i);
        // mp.add();
        // Called when Motion Detected
        Toast.makeText(getBaseContext(), "Motion detected",
                Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
    @Override
    public void onStop()
    {
        super.onStop();

        //Check device supported Accelerometer sensor or not
        if (AccelerometerManager.isListening()) {

            //Start Accelerometer Listening
            AccelerometerManager.stopListening();
            finish();

            Toast.makeText(getBaseContext(), "Accelerometer Stoped",
                    Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.i("Sensor", "Service  destroy");

        //Check device supported Accelerometer sensor or not
        if (AccelerometerManager.isListening())
        {

            //Start Accelerometer Listening
            AccelerometerManager.stopListening();
            finish();

            Toast.makeText(getBaseContext(), "onDestroy Accelerometer Stoped",
                    Toast.LENGTH_SHORT).show();
        }

    }

}
