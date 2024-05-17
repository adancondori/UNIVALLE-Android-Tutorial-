package com.example.univalle_android_tutorial.service_pokemon;

import com.example.univalle_android_tutorial.requests.RegisterRequest;
import com.example.univalle_android_tutorial.service.RegisterResponse;
import com.example.univalle_android_tutorial.service.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PokeAPI {
    @GET("/api/users")
    Call<UserResponse> getAllUser();
    @GET("/api/users")
    Call<UserResponse> getUserPerPage(@Query("page") int page, @Query("per_page") int per_page);
    @POST("/api/register")
    Call<RegisterResponse> registerUser(@Body RegisterRequest request);

}