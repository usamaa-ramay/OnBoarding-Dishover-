package com.example.e_commerce_app.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.e_commerce_app.data.utils.Utiles;
import com.example.e_commerce_app.data.models.AuthToken;
import com.example.e_commerce_app.data.models.LogInData;
import com.example.e_commerce_app.databinding.ActivityLogInBinding;
import com.example.e_commerce_app.ui.home.HomeActivity;
import com.example.e_commerce_app.ui.login.model.LogInViewModel;
import com.example.e_commerce_app.ui.signup.SignUpActivity;

public class LogInActivity extends AppCompatActivity {
    private ActivityLogInBinding binding;
    LogInViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginViewModel = new ViewModelProvider(this).get(LogInViewModel.class);

        loginViewModel._accessToken.observe(this, new Observer<AuthToken>() {
            @Override
            public void onChanged(AuthToken authToken) {

                Utiles.saveString(LogInActivity.this,"access_token",authToken.getAccess_token());

                startActivity(new Intent(LogInActivity.this, HomeActivity.class));
                finish();
                Toast.makeText(LogInActivity.this, "logIn", Toast.LENGTH_SHORT).show();
            }
        });


        binding.btnLogin.setOnClickListener(view->{
            String email = binding.emailET.getText().toString();
            String password = binding.passwordET.getText().toString();
            LogInData data = new LogInData();
            data.setEmail(email);
            data.setPassword(password);
            loginViewModel.setLogInModel(data);

        });

        binding.signUPTV.setOnClickListener(view->{
            startActivity(new Intent(LogInActivity.this, SignUpActivity.class));
        });


    }
}