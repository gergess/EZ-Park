package com.ez.ez_park.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.ez.ez_park.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int SPLASH_TIMEOUT = 4000;
        Animation animate = AnimationUtils.loadAnimation(this,R.anim.scaling);
        TextView nameText = findViewById(R.id.tvAppName);

        nameText.startAnimation(animate);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent();
                setResult(RESULT_OK, homeIntent);
                finish();
            }
        }, SPLASH_TIMEOUT);

    }
}
