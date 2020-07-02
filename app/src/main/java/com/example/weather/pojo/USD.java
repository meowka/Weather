package com.example.weather.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USD {

    @SerializedName("ID")
    @Expose
    public String iD;
    @SerializedName("NumCode")
    @Expose
    public String numCode;
    @SerializedName("CharCode")
    @Expose
    public String charCode;
    @SerializedName("Nominal")
    @Expose
    public Integer nominal;
    @SerializedName("Name")
    @Expose
    public String name;
    @SerializedName("Value")
    @Expose
    public Double value;
    @SerializedName("Previous")
    @Expose
    public Double previous;

    public USD(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }
}
