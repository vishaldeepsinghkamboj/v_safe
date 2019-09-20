package com.example.vishaldeepsingh.vsafe.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.vishaldeepsingh.vsafe.R;

public class DialogBoxActivity extends AppCompatActivity {
    Dbhelper dbh;
    SQLiteDatabase dd;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_box);
        dbh=new Dbhelper(getApplicationContext());
        dd=dbh.getWritableDatabase();

        AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(this).setIcon(R.drawable.alerticon);

        alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplication(),"Ok",Toast.LENGTH_SHORT).show();
                Intent instructionIntent=new Intent(DialogBoxActivity.this,RegisterActivity.class);
                startActivity(instructionIntent);
                finish();

            }
        });
        alertDialogBuilder.setNegativeButton("skip", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dd=openOrCreateDatabase("Mydb.db",Context.MODE_PRIVATE,null);
                c=dd.rawQuery("Select * from user_info",null);

                if(c.getCount()==0){
                    Toast.makeText(getApplicationContext(), "Create Your First Account",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(DialogBoxActivity.this,RegisterActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Already register ",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(DialogBoxActivity.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
                //Intent i=new Intent(Dialogbox.this,Signup.class);
                //startActivity(i);
                //finish();


            }


        });
        AlertDialog alert=alertDialogBuilder.create();
        alert.setTitle("Register yourself first...");
        alert.setCanceledOnTouchOutside(false);
        alert.show();

    }

}
