package com.example.mthwapp;

import com.example.mthwapp.retrofit.model.CurrentWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TService {

    @GET("current")
    Call<CurrentWeather> getCurrentWeather(@Query("access_key") String access_key,@Query("query") String query);

}