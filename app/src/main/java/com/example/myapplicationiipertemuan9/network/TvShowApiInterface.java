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
    @GET("tv/{sort_by")
    Call<TvShowPlayingResponse> getTvPlaying(
            @Path("sort_by") String sortBy,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );

    @GET("tv/{tv_id}")
    Call<TvShow> getTvShow(@Path("tv_id") String id, @Query("api_key") String apikey);
    Call<TvShow> getDetail(@Path("id") int id, @Query("api_key")String apikey, @Path("language") String language);

    @GET("search/tv")
    Call<TvShowPlayingResponse> search(
            @Query("api_key") String apiKey,
            @Query("query") String query,
            @Query("language") String language,
            @Query("page") int page
    );
}
