package com.example.weather;

import com.example.weather.pojo.MultipleResource;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface APIInterface {

    @GET("scripts/XML_daily.asp?")
    Call<List<MultipleResource>> doGetListResources(@Query("date_req") int dateReq);

}
