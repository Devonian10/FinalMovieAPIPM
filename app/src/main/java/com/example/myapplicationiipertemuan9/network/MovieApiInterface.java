package com.example.myapplicationiipertemuan9.network;

import com.example.myapplicationiipertemuan9.models.SearchResponse;
import com.example.myapplicationiipertemuan9.models.DashboardResponse;
import com.example.myapplicationiipertemuan9.models.HomePlayingResponse;
import com.example.myapplicationiipertemuan9.models.movie.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApiInterface {
    // https://api.themoviedb.org/3/movie/now_playing
    @GET("now_playing")
    Call<HomePlayingResponse> getNowPlaying(
            @Query("api_key") String apiKey
    );
    @GET("movie/{movie_id}")
    Call<Movie> getMovie(
            @Path("movie_id") String id,
            @Query("api_key") String apiKey
    );
    @GET("Upcoming")
    Call<SearchResponse> getUpcomings(
            @Query("api_key") String apiKey);

    @GET("Popular")
    Call<DashboardResponse> getPopulars(@Query("api_key") String apiKey);
}
