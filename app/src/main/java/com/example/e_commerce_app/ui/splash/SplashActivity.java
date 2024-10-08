package com.example.e_commerce_app.ui.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.e_commerce_app.data.utils.Utiles;
import com.example.e_commerce_app.databinding.ActivitySplashBinding;
import com.example.e_commerce_app.ui.home.HomeActivity;
import com.example.e_commerce_app.ui.login.LogInActivity;
import com.example.e_commerce_app.ui.onboarding.OnBoardingActivity;

public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        boolean isStarted = Utiles.getBoolean(SplashActivity.this, "onBoarding", false);
        String accessToken = Utiles.getString(SplashActivity.this,"access_token", null);

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (!isStarted) {
                    startActivity(new Intent(SplashActivity.this, OnBoardingActivity.class));
                } else if (isStarted && accessToken == null) {
                    startActivity(new Intent(SplashActivity.this, LogInActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                }
                finish();
            }
        };
        handler.postDelayed(runnable, 3000);
    }
}