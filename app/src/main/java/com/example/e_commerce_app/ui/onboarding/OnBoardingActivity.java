package com.example.e_commerce_app.ui.onboarding;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.e_commerce_app.MainActivity;
import com.example.e_commerce_app.R;
import com.example.e_commerce_app.data.utils.Utiles;
import com.example.e_commerce_app.data.models.OnBoardingData;
import com.example.e_commerce_app.databinding.ActivityOnBoardingBinding;
import com.example.e_commerce_app.ui.login.LogInActivity;
import com.example.e_commerce_app.ui.onboarding.adapter.OnBoardingAdapter;

import java.util.ArrayList;

public class OnBoardingActivity extends AppCompatActivity {
    private ActivityOnBoardingBinding binding;
    private ViewPager2 viewPager;
    ArrayList<OnBoardingData> onBoardingData;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnBoardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewPager = binding.viewpager;
        onBoardingData = new ArrayList<>();
        sharedPreferences = getSharedPreferences("appPreferences",MODE_PRIVATE);

        binding.skipBtn.setOnClickListener(view->{
            startActivity(new Intent(OnBoardingActivity.this, MainActivity.class));
        });

        OnBoardingData boardingData = new OnBoardingData();
        boardingData.setImage(R.drawable.boarding_img1);
        boardingData.setTitle("Fresh Meals");
        boardingData.setContent("Discover fresh, healthy meals\n delivered straight to your\n door.");
        onBoardingData.add(boardingData);

        boardingData = new OnBoardingData();
        boardingData.setImage(R.drawable.boarding_img2);
        boardingData.setTitle("Quick Delivery");
        boardingData.setContent("Get your meals delivered quickly\n and conveniently");
        onBoardingData.add(boardingData);

        boardingData = new OnBoardingData();
        boardingData.setImage(R.drawable.boarding_img3);
        boardingData.setTitle("Start Today!");
        boardingData.setContent("Start your culinary journey\n with us today!");
        onBoardingData.add(boardingData);

        OnBoardingAdapter onBoardingAdapter = new OnBoardingAdapter(onBoardingData,this);
        binding.viewpager.setAdapter(onBoardingAdapter);

        binding.viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeIndicator(position);
            }
        });

        binding.startbtnCV.setOnClickListener(v -> {
            int currentItem = viewPager.getCurrentItem();


            if (currentItem == onBoardingData.size() - 1) {
                startActivity(new Intent(OnBoardingActivity.this, LogInActivity.class));
                Utiles.saveBoolean(OnBoardingActivity.this,"onBoarding",true);
            } else {
                viewPager.setCurrentItem(currentItem + 1);
            }
        });



    }

    private void changeIndicator(int position) {
        switch (position){
            case 0:
                binding.c1.setCardBackgroundColor(ContextCompat.getColor(this, R.color.primaryColor));
                binding.c2.setCardBackgroundColor(ContextCompat.getColor(this, R.color.secondaryColor));
                binding.c3.setCardBackgroundColor(ContextCompat.getColor(this, R.color.secondaryColor));
                break;
            case 1:
                binding.c1.setCardBackgroundColor(ContextCompat.getColor(this, R.color.secondaryColor));
                binding.c2.setCardBackgroundColor(ContextCompat.getColor(this, R.color.primaryColor));
                binding.c3.setCardBackgroundColor(ContextCompat.getColor(this, R.color.secondaryColor));
                break;
            case 2:
                binding.c1.setCardBackgroundColor(ContextCompat.getColor(this, R.color.secondaryColor));
                binding.c2.setCardBackgroundColor(ContextCompat.getColor(this, R.color.secondaryColor));
                binding.c3.setCardBackgroundColor(ContextCompat.getColor(this, R.color.primaryColor));
                break;
            default:
                Toast.makeText(this,"invalid case", Toast.LENGTH_SHORT).show();
        }
        if (position==2){
            binding.btnTV.setText("Start");
        }else binding.btnTV.setText("Next");
    }
}