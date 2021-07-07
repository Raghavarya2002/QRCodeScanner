package com.example.qrcodescanner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qrcodescanner.MainActivity;
import com.example.qrcodescanner.R;

public class SplashActivity extends AppCompatActivity {


    //constant time delay
    private final int SPLASH_DELAY = 2500;

    //fields (widget)

    private ImageView  imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setBackgroundDrawable(null);

        //methods to call
        initializeview();
        animatelogo();
        goToMainActivity();

    }

    private void goToMainActivity() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }, SPLASH_DELAY);
    }

    private void animatelogo() {

        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_without_duration);
        fadingInAnimation.setDuration(SPLASH_DELAY);
        imageview.startAnimation(fadingInAnimation);
    }

    private void initializeview() {

        imageview = findViewById(R.id.imageView);
    }
}