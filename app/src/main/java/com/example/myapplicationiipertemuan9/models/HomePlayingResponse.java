package com.example.myapplicationiipertemuan9.models;

import com.example.myapplicationiipertemuan9.models.tv.TvShow;
import com.google.gson.annotations.*;
import java.util.*;

public class HomePlayingResponse {
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @SerializedName("page")
    @Expose
    private int page;

    @SerializedName("results")
    @Expose
    private List<HomePlaying> nowPlayings;

    public List<HomePlaying> getNowPlayings() {
        return nowPlayings;
    }
}
