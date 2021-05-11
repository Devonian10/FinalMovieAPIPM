package com.example.myapplicationiipertemuan9.models;

import com.google.gson.annotations.*;
import java.util.*;

public class SearchResponse {
    @SerializedName("results")
    @Expose
    private List<Search> upcomings;

    public List<Search> getUpcomings() {
        return upcomings;
    }
}
