package com.example.e_commerce_app.ui.signup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.e_commerce_app.data.models.CreatUserData;
import com.example.e_commerce_app.data.models.LogInData;
import com.example.e_commerce_app.databinding.ActivitySignUpBinding;
import com.example.e_commerce_app.ui.signup.model.SignUpViewModel;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SignUpViewModel signUpViewModel = new ViewModelProvider(this).get(SignUpViewModel.class);
        signUpViewModel._CreatUser.observe(this, new Observer<CreatUserData>() {
            @Override
            public void onChanged(CreatUserData creatUserData) {
//                Utiles.saveObject(SignUpActivity.this,"signup",CreatUserData.class);
                startActivity(new Intent(SignUpActivity.this, LogInData.class));
                finish();
                Toast.makeText(SignUpActivity.this, "SignUp successful", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnSignUp.setOnClickListener(view -> {
            String name = binding.nameET.getText().toString();
            String email = binding.emailET.getText().toString();
            String password = binding.passwordET.getText().toString();
            CreatUserData data = new CreatUserData();
            data.setEmail(name);
            data.setEmail(email);
            data.setPassword(password);
            SignUpViewModel.setNewCreatUser(data);

        });

        binding.btnLoginTV.setOnClickListener(view->{
            startActivity(new Intent(SignUpActivity.this, LogInData.class));
        });
    }
}