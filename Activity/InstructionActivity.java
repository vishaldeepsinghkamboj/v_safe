package com.example.vishaldeepsingh.vsafe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.vishaldeepsingh.vsafe.R;

public class InstructionActivity extends AppCompatActivity {
    Button nextBtn;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
       // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        scrollView=(ScrollView)findViewById(R.id.scrollView);
        nextBtn=(Button)findViewById(R.id.nextBTN);
        nextBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent=new Intent(InstructionActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}

