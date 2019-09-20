package com.example.vishaldeepsingh.vsafe.Activity;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vishaldeepsingh.vsafe.R;

public class PhotoActivity extends Activity {
    protected static final int CAMERA_PIC_REQUEST=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        Intent cameraIntent= new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent,CAMERA_PIC_REQUEST);
    }
}
