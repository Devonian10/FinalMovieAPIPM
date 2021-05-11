package com.example.myapplicationiipertemuan9.models;


import com.google.gson.annotations.*;

import java.util.List;

public class TvShowPlayingResponse {
    @SerializedName("results")
    @Expose
    private List<TvShowPlaying> tvPlaying;

    public List<TvShowPlaying> getTvPlaying(){
        return tvPlaying;
    }
}
