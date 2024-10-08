package com.example.e_commerce_app.ui.signup.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_commerce_app.data.RetrofitClient.RetrofitClient;
import com.example.e_commerce_app.data.models.CreatUserData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpViewModel extends ViewModel {
    private static MutableLiveData<CreatUserData> newCreatUser = new MutableLiveData<>();
    public LiveData<CreatUserData> _CreatUser = newCreatUser;

    public static void setNewCreatUser(CreatUserData creatUser) {
        RetrofitClient.getGetPlatziApiService().getCreatUser(creatUser).enqueue(new Callback<CreatUserData>() {
            @Override
            public void onResponse(Call<CreatUserData> call, Response<CreatUserData> response) {
                Log.d("signup",response.body().getName());
                newCreatUser.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CreatUserData> call, Throwable t) {
                Log.d("dhbh", t.getLocalizedMessage());
            }
        });
    }
}
