package com.example.e_commerce_app.ui.login.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_commerce_app.data.RetrofitClient.RetrofitClient;
import com.example.e_commerce_app.data.models.AuthToken;
import com.example.e_commerce_app.data.models.LogInData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInViewModel extends ViewModel {
    private MutableLiveData<AuthToken> authToken = new MutableLiveData<>();
    public LiveData<AuthToken> _accessToken = authToken;

    public void setLogInModel(LogInData data) {
        RetrofitClient.getGetPlatziApiService().getUser(data).enqueue(new Callback<AuthToken>() {
            @Override
            public void onResponse(Call<AuthToken> call, Response<AuthToken> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("login",response.body().getAccess_token());
                    authToken.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<AuthToken> call, Throwable t) {
                Log.d("ddz", t.getLocalizedMessage());
            }
        });
    }
}
