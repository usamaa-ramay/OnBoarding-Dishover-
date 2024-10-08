package com.example.e_commerce_app.ui.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.e_commerce_app.data.utils.Utiles;
import com.example.e_commerce_app.data.models.CreatUserData;
import com.example.e_commerce_app.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Utiles.getObject(HomeActivity.this,"signup", CreatUserData.class);


    }
}