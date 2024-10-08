package com.example.e_commerce_app.data.ApiService;

import com.example.e_commerce_app.data.models.AuthToken;
import com.example.e_commerce_app.data.models.CreatUserData;
import com.example.e_commerce_app.data.models.LogInData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("api/v1/auth/login")
    Call<AuthToken> getUser(@Body LogInData loginData);

    @POST("api/v1/users/")
    Call<CreatUserData> getCreatUser(@Body CreatUserData newUser );
}
