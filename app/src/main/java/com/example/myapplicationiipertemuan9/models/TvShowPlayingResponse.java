package com.example.myapplicationiipertemuan9.models;


import com.example.myapplicationiipertemuan9.models.tv.TvShow;
import com.google.gson.annotations.*;

import java.util.List;

public class TvShowPlayingResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int totalresults;

    @SerializedName("total_page")
    private int totalpage;
    @SerializedName("results")
    @Expose
    private List<TvShowPlaying> tvPlaying;

    public List<TvShowPlaying> getTvPlaying(){
        return tvPlaying;
    }

    public int getPage() {
        return page;
    }

    public int getTotalresults() {
        return totalresults;
    }


    public int getTotalpage() {
        return totalpage;
    }



}
