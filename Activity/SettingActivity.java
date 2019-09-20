package com.example.vishaldeepsingh.vsafe.Activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vishaldeepsingh.vsafe.R;

public class SettingActivity extends AppCompatActivity
{
    SQLiteDatabase dd;
    Cursor c,c1;
    EditText verifyEmailEdt;
    EditText verifyContactEdt;
    Button verifyEmergencyContactBtn;
    String email,contact,Emailid,Phoneno;
    Dbhelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        verifyEmailEdt=(EditText)findViewById(R.id.verifyEmailEDT);
        verifyContactEdt=(EditText)findViewById(R.id.verifyContactEDT) ;

        verifyEmergencyContactBtn=(Button)findViewById(R.id.verifyEmergencyContactBTN);
        verifyEmergencyContactBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                email=verifyEmailEdt.getText().toString();
                contact=verifyContactEdt.getText().toString();
                dd=openOrCreateDatabase("Mydb.db",Context.MODE_PRIVATE,null);
                c=dd.rawQuery("select * from user_info",null);
                // dd=new UpdateEmergencyContact(getApplicationContext());
                //dd=dbh.getWritableDatabase();
                while(c.moveToNext())
                {
                    Phoneno=c.getString(2);
                    Emailid=c.getString(1);

                    Log.i("msg","****"+Emailid+" "+Phoneno);
                    if(email.equals(Emailid)&&contact.equals(Phoneno))
                    {
                        c1=dd.rawQuery("select * from user_info1",null);
                        dd.delete("user_info1",null, null);

                        Log.i("my msg","value of");
                        Toast.makeText(getApplicationContext(), "enter new values", Toast.LENGTH_LONG).show();
                        Intent i=new Intent(SettingActivity.this,EmergencyContactsActivity.class);
                        startActivity(i);

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "not valid",Toast.LENGTH_LONG).show();
                        //dbh.close();
                    }
                }
            }
        });
    }
}
