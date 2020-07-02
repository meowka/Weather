package com.example.weather;

import com.example.weather.pojo.USD;

import retrofit2.Call;
import retrofit2.http.GET;


public interface APIInterface {

    @GET("daily_json.js")
    Call<USD> doGetListResources();

}
