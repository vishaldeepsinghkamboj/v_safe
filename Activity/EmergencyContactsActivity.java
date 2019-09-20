package com.example.vishaldeepsingh.vsafe.Activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vishaldeepsingh.vsafe.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class EmergencyContactsActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3;
    EditText ed1, ed2, ed3, ed4;
    Button bt1, bt2, bt3;
    Dbhelper dbh;
    SQLiteDatabase dd;
    String name1, phn1, name2, phn2;
    Cursor c;

    public static final int PICK_CONTACT = 1;
    public static final int PICK_CONTACT1 = 2;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_contacts);

        // im=(ImageView)findViewById(R.id.imageView1);
        //  Animation animation=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        //  im.startAnimation(animation);
        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        //  Animation am=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        // tv2.startAnimation(am);
        tv3 = (TextView) findViewById(R.id.textView3);
        //   Animation an=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        // tv3.startAnimation(an);
        ed1 = (EditText) findViewById(R.id.editText1);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);
        ed4 = (EditText) findViewById(R.id.editText4);
        bt1 = (Button) findViewById(R.id.button1);

        bt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                name2 = ed3.getText().toString();
                name1 = ed1.getText().toString();
                phn1 = ed2.getText().toString();
                phn2 = ed4.getText().toString();

                if (name1.equals("") || phn1.equals("") || name2.equals("") || phn2.equals("")) {
                    Toast.makeText(getApplication(), "fields are empty", Toast.LENGTH_LONG).show();
                } else if (phn1.length() < 10 || phn2.length() < 10) {
                    Toast.makeText(getApplicationContext(), "no is incorrect", Toast.LENGTH_LONG).show();
                } else {
                    Log.i("my msg", "***********************888");

                    dbh = new Dbhelper(getApplicationContext());

                    dd = openOrCreateDatabase("Mydb.db", Context.MODE_PRIVATE, null);
                    dbh.insertcontact1(name1, phn1, name2, phn2);

                    Log.i("my msg", "" + name1 + "" + phn1 + "" + "" + name2 + "" + phn2);

                    dbh.close();
                    Toast.makeText(getApplicationContext(), "contact is saved", Toast.LENGTH_LONG).show();
                    finish();
                    Intent i = new Intent(EmergencyContactsActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }

        });
        bt2 = (Button) findViewById(R.id.choosecontact1);
        bt2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
                startActivityForResult(intent, 1);

            }
        });
        bt3 = (Button) findViewById(R.id.choosecotact2);
        bt3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
                startActivityForResult(intent, 2);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_CONTACT) {
            if (resultCode == RESULT_OK) {
                Uri contactData = data.getData();
                Cursor cursor = managedQuery(contactData, null, null, null, null);
                cursor.moveToFirst();
                String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                ed1.setText(name);
                String number = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));

                ed2.setText(number);

            }
        }
        if (requestCode == PICK_CONTACT1) {
            if (resultCode == RESULT_OK) {
                Uri contactData = data.getData();
                Cursor cursor = managedQuery(contactData, null, null, null, null);
                cursor.moveToFirst();
                String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                ed3.setText(name);

                String number = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));

                ed4.setText(number);

            }

        }
    }


}






