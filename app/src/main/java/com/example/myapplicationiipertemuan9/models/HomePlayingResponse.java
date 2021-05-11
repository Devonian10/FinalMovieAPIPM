package com.example.myapplicationiipertemuan9.models;

import com.google.gson.annotations.*;
import java.util.*;

public class HomePlayingResponse {
    @SerializedName("results")
    @Expose
    private List<HomePlaying> nowPlayings;

    public List<HomePlaying> getNowPlayings() {
        return nowPlayings;
    }
}
