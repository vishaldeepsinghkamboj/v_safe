package com.example.vishaldeepsingh.vsafe.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.vishaldeepsingh.vsafe.R;

public class SplashActivity extends AppCompatActivity {
    ImageView imgView;
    TextView womenSafetyTV;
    ProgressBar progressBar;
    int progressT = 0;
    Handler handler = new Handler();
    ShapeDrawable pgDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
      //  Animation fadeAnimation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.);
        womenSafetyTV = (TextView) findViewById(R.id.womenSafetyTV);
       // womenSafetyTV.startAnimation(fadeAnimation);
        progressBar = (ProgressBar) findViewById(R.id.pgBar);

        final float[] roundedCorners = new float[] { 5, 5, 5, 5, 5, 5, 5, 5 };
        pgDrawable = new ShapeDrawable(new RoundRectShape(roundedCorners, null,
                null));
        String MyColor = "#00bfff";
        pgDrawable.getPaint().setColor(Color.parseColor(MyColor));
        ClipDrawable progress = new ClipDrawable(pgDrawable, Gravity.LEFT,
                ClipDrawable.HORIZONTAL);
        progressBar.setProgressDrawable(progress);
        progressBar.setBackgroundDrawable(getResources().getDrawable(
                android.R.drawable.progress_horizontal));
        progressBar.setProgress(45);

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    progressT += 2;
                    handler.post(new Runnable() {

                        @Override
                        public void run() {

                            progressBar.setProgress(progressT);
                            if (progressT == progressBar.getMax()) {
                                progressBar.setVisibility(View.VISIBLE);
                                Intent intent = new Intent(SplashActivity.this,
                                        DialogBoxActivity.class);
                                startActivity(intent);
                            }
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

    }

    protected void onPause() {
        super.onPause();
        finish();

    }





}

