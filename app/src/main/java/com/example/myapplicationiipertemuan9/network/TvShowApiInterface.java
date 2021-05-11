package com.example.myapplicationiipertemuan9.network;

import com.example.myapplicationiipertemuan9.models.tv.TvShow;
import com.example.myapplicationiipertemuan9.models.TvShowPlayingResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TvShowApiInterface {
    @GET("airing_today")
    Call<TvShowPlayingResponse>
    getAiringToday(@Query("api_key") String apikey);

    @GET("tv/{tv_id}")
    Call<TvShow> getTvShow(@Path("tv_id") String id, @Query("api_key") String apikey);
}
