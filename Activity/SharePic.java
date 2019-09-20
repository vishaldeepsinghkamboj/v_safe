package com.example.vishaldeepsingh.vsafe.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.vishaldeepsingh.vsafe.R;

import java.io.File;
import java.util.ArrayList;

public class SharePic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_pic);
        Intent intent=null,chooser=null;
        //File pictures=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File mediaStorageDir = new File("/sdcard/", "JCG Camera");
        String[] listofPictures=mediaStorageDir.list();
        Uri uri=null;
        ArrayList<Uri>arrayList=new ArrayList<Uri>();
        for(String picture:listofPictures)
        {
            uri= Uri.parse("file://"+mediaStorageDir.toString()+"/"+picture);
            arrayList.add(uri);
        }
        try
        {
            intent=new Intent(Intent.ACTION_SEND_MULTIPLE);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM,arrayList);
            chooser=Intent.createChooser(intent, "send multiple images");
            startActivity(chooser);
           // Toast.makeText(getApplicationContext(), "Your pictures are sent successfully", Toast.LENGTH_SHORT).show();

        }
        finally
        {
            finish();
        }

    }

}

