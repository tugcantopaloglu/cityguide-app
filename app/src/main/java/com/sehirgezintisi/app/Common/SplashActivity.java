package com.sehirgezintisi.app.Common;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sehirgezintisi.app.R;
import com.sehirgezintisi.app.User.MainActivity;

public class SplashActivity extends AppCompatActivity {

    ImageView logoImageView;
    TextView copyrightsTextView;

    Animation logo_anim, bottom_anim;

    SharedPreferences onBoardingPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        logoImageView = findViewById(R.id.logo_image);
        copyrightsTextView = findViewById(R.id.copyrights);

        logo_anim = AnimationUtils.loadAnimation(this, R.anim.splash_logo_anim);
        bottom_anim = AnimationUtils.loadAnimation(this, R.anim.splash_bottom_anim);

        logoImageView.setAnimation(logo_anim);
        copyrightsTextView.setAnimation(bottom_anim);

        Handler handler = new Handler();
        handler.postDelayed(() -> {

            onBoardingPref = getSharedPreferences("onBoardingPref", MODE_PRIVATE);

            boolean firstTime = onBoardingPref.getBoolean("firstTime", true);

            if (firstTime) {
                onBoardingPref.edit().putBoolean("firstTime", false).apply();
                Intent intent = new Intent(SplashActivity.this, OnBoardingActivity.class);
                startActivity(intent);

            } else {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }

            finish();

        }, 3000);
    }
}