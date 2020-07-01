package com.example.weather.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MultipleResource {

    private  int id;
    private String name;
    private float value;


    @SerializedName("body")
    private  String text;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getValue() {
        return value;
    }
}
