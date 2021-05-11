package com.example.myapplicationiipertemuan9.models;
import com.google.gson.annotations.*;
import java.util.*;
public class DashboardResponse {
    @SerializedName("results")
    @Expose
    private List<Dashboard> populars;

    public List<Dashboard> getPopulars() {
        return populars;
    }
}
