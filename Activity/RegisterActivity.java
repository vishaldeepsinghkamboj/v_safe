package com.example.vishaldeepsingh.vsafe.Activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.vishaldeepsingh.vsafe.R;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3, ed4;

    Button bt;
    //ImageView img;
    // Animation animation;
    Dbhelper dbh;
    SQLiteDatabase dd;
    String name1, phn1, email1, address1;
    Cursor c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dbh = new Dbhelper(getApplicationContext());
        dd = dbh.getWritableDatabase();


        //  imv2=(ImageView)findViewById(R.id.signup);
        bt = (Button) findViewById(R.id.bregister);
        ed1 = (EditText) findViewById(R.id.ed1name);
        ed2 = (EditText) findViewById(R.id.ed1no);
        ed3 = (EditText) findViewById(R.id.ed1email);
        ed4 = (EditText) findViewById(R.id.ed1city);

        dbh = new Dbhelper(getApplicationContext());
        dbh = new Dbhelper(getApplicationContext());
        dd = dbh.getWritableDatabase();


        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                name1 = ed1.getText().toString();
                phn1 = ed2.getText().toString();
                email1 = ed3.getText().toString();
                address1 = ed4.getText().toString();


                if (name1.equals("") || email1.equals("") || phn1.equals("") || address1.equals("")) {
                    Toast.makeText(getApplication(), "fields are empty", Toast.LENGTH_LONG).show();
                } else if (phn1.length() < 10) {
                    Toast.makeText(getApplicationContext(), "no is incorrect", Toast.LENGTH_LONG).show();
                } else if (name1.length() < 0 || name1.length() > 10) {
                    //name1.setError("Error");
                    Toast.makeText(getApplicationContext(), "name should be of minimum 10 character", Toast.LENGTH_LONG).show();

                } else {
                    Log.i("my msg", "***********************888");

                    dbh = new Dbhelper(getApplicationContext());

                    dd = openOrCreateDatabase("Mydb.db", Context.MODE_PRIVATE, null);
                    dbh.insertcontact(name1, email1, phn1, address1);

                    Log.i("my msg", "" + name1 + "" + email1 + "" + "" + phn1 + "" + address1);

                    dbh.close();
                    Toast.makeText(getApplicationContext(), "contact is created name", Toast.LENGTH_LONG).show();
                    finish();
                    Intent i = new Intent(RegisterActivity.this, EmergencyContactsActivity.class);
                    startActivity(i);
                }
            }


        });

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}










