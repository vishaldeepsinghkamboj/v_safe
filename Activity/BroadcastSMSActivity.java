package com.example.vishaldeepsingh.vsafe.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import com.example.vishaldeepsingh.vsafe.R;

import java.util.ArrayList;

public class BroadcastSMSActivity extends AppCompatActivity {
    String SMS,msg;
    SQLiteDatabase dd;
    Dbhelper dh;
    Cursor c;
    Cursor c1;
    String s1,s2,message,s3,address;
    ApplicationLocationService appLocationService;

    public String locationAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_sms);
        appLocationService = new ApplicationLocationService(
                BroadcastSMSActivity.this);
        add();
      //  System.out.println("add is called");
        Log.i("MyMsg"," OnCreate method of BroadcastActivity");

    }
    public void add() {
        appLocationService=new ApplicationLocationService(BroadcastSMSActivity.this);
        Location location = appLocationService
                .getLocation(LocationManager.GPS_PROVIDER);
      //  Toast.makeText(getApplicationContext(), "address method", Toast.LENGTH_SHORT).show();
        if (location != null) {
           // Toast.makeText(getApplicationContext(), "address method1", Toast.LENGTH_SHORT).show();
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            //  double latitude=30.685164;
            //double longitude=76.694698;
            LocationAddress locationAddress = new LocationAddress();
            LocationAddress.getAddressFromLocation(latitude, longitude,
                    getApplicationContext(), new GeocoderHandler());
        }
        else
        {
            Log.i("my msg","GPS is not started");
                     showSettingsAlert();
            dd=openOrCreateDatabase("Mydb.db",Context.MODE_PRIVATE,null);
            c1=dd.rawQuery("Select * from user_info1",null);

            if(c1.getCount()==0)
            {
                Toast.makeText(getApplicationContext(),"No Emergency contact is found",Toast.LENGTH_SHORT).show();

            }
            else
            {
             while(c1.moveToNext())
             {
                 s2=c1.getString(1);
                 s3=c1.getString(3);
                 System.out.println("data"+s2+""+s3);
             }
                Toast.makeText(getApplicationContext(),"GPS is not working Properly try again later!",Toast.LENGTH_SHORT).show();

                SmsManager sm=SmsManager.getDefault();
                sm.sendTextMessage(s2,null,"I am in trouble i need your help!",null,null);
                sm.sendTextMessage(s3,null,"I am in trouble i need your help!",null,null);
                Toast.makeText(getApplicationContext(),"SMS sent to"+s2,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"SMS sent to"+s3,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Camera called",Toast.LENGTH_SHORT).show();
                finish();
                Intent i=new Intent(BroadcastSMSActivity.this,SurfaceActivity.class);
                startActivity(i);
                stop();
            }
        }

    }
    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                BroadcastSMSActivity.this);
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        BroadcastSMSActivity.this.startActivity(intent);
                    }
                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }
    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            // String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
                    Toast.makeText(getApplicationContext(), "GeocoderHandler called", Toast.LENGTH_SHORT).show();

            }
            Toast.makeText(getApplicationContext(), locationAddress, Toast.LENGTH_SHORT).show();
            sms();
            finish();
            Intent i=new Intent(BroadcastSMSActivity.this,CaptureActivity.class);
            startActivity(i);
        }
    }
    public void sms()
    {
        dd=openOrCreateDatabase("Mydb.db", Context.MODE_PRIVATE,null);
        c=dd.rawQuery("Select * from user_info",null);
        c1=dd.rawQuery("Select * from user_info1",null);
        while(c.moveToNext()){
            s1=c.getString(1);
            Log.i("msg", "************SMS MANAGER");
        }

        c.close();

        if (s1.equals("")) {

            Toast.makeText(getApplicationContext(),
                    "Please insert your number first",
                    Toast.LENGTH_SHORT).show();
        }
        else
        {
            while (c1.moveToNext())
            {
                s2 =c1.getString(1);
                s3=c1.getString(3);
                System.out.println("----data--" + s2+""+s3);
                try {
                    String ss="help me this is where i am :";
                    String sss=ss+locationAddress;

                    SmsManager smsManager = SmsManager.getDefault();
                    ArrayList<String> parts=smsManager.divideMessage(sss);

                        smsManager.sendMultipartTextMessage(s2, null, parts, null, null);
                       smsManager.sendMultipartTextMessage(s3, null, parts, null, null);

                    Toast.makeText(getApplicationContext(), parts+"sms sent", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "sms sent to "+s2, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "sms sent to "+s3, Toast.LENGTH_SHORT).show();
                    ShakeActivity sk=new ShakeActivity();
                    sk.onStop();

                   // Toast.makeText(getApplicationContext(), "Service stopped successfully", Toast.LENGTH_SHORT).show();



                    System.out.println("================" + locationAddress);


                    Log.e("my msg", "*****************************final code ");

                    Toast.makeText(getApplicationContext(), "SMS Sent Source:" + s1 + "Target:" + s2+"Message:", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(),"Camera Called",Toast.LENGTH_SHORT).show();
                    stop();

                } catch(Exception e)
                {
                    e.printStackTrace();

                }
            }
        }
    }
    public void stop()
    {
        finish();
    }


}
