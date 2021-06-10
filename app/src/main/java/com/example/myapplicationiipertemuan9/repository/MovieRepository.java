package com.example.myapplicationiipertemuan9.repository;

import androidx.annotation.NonNull;

import com.example.myapplicationiipertemuan9.models.HomePlaying;
import com.example.myapplicationiipertemuan9.models.HomePlayingResponse;
import com.example.myapplicationiipertemuan9.models.TvShowPlayingResponse;
import com.example.myapplicationiipertemuan9.models.tv.TvShow;
import com.example.myapplicationiipertemuan9.network.Const;
import com.example.myapplicationiipertemuan9.network.MovieApiInterface;
import com.example.myapplicationiipertemuan9.network.TvShowApiInterface;
import com.example.myapplicationiipertemuan9.repository.callback.OnMovieDetailCallback;
import com.example.myapplicationiipertemuan9.repository.callback.OnMoviePlayingCallback;
import com.example.myapplicationiipertemuan9.repository.callback.OnSearchCallback;
import com.example.myapplicationiipertemuan9.repository.callback.OnTvDetailCallback;
import com.example.myapplicationiipertemuan9.repository.callback.OnTvShowCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieRepository {
    private static MovieRepository repository;
    private MovieApiInterface service;

    private MovieRepository(MovieApiInterface service) {
        this.service = service;
    }

    public static MovieRepository getInstance() {
        if (repository == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Const.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            repository = new MovieRepository(retrofit.create(MovieApiInterface.class));
        }
        return repository;
    }

    public void getMovie(String sortBy, int page, final OnMoviePlayingCallback callback) {
        service.getNowPlaying(sortBy, Const.API_KEY, Const.getLang(), page)
                .enqueue(new Callback<TvShowPlayingResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<TvShowPlayingResponse> call, @NonNull Response<TvShowPlayingResponse> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                if (response.body().getTvPlaying() != null) {
                                    callback.onSuccess(response.body().getPage(), response.body().getTvPlaying());
                                } else {
                                    callback.onFailure("response.body().getResults() is null");
                                }
                            } else {
                                callback.onFailure("response.body() is null");
                            }
                        } else {
                            callback.onFailure(response.message());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<TvShowPlayingResponse> call, @NonNull Throwable t) {
                        callback.onFailure(t.getLocalizedMessage());
                    }
                });
    }

    public void getTvDetail(int id, final OnMovieDetailCallback callback) {
        service.getDetail(id, Const.API_KEY, Const.getLang())
                .enqueue(new Callback<HomePlaying>() {
                    @Override
                    public void onResponse(@NonNull Call<HomePlaying> call, @NonNull Response<HomePlaying> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                callback.onSuccess(response.body(), response.message());
                            } else {
                                callback.onFailure("response.body() is null");
                            }
                        } else {
                            callback.onFailure(response.message() + ", Error Code : " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<HomePlaying> call, @NonNull Throwable t) {
                        callback.onFailure(t.getLocalizedMessage());
                    }
                });
    }

    public void search(String query, int page, final OnSearchCallback callback) {
        service.search(Const.API_KEY, query, page)
                .enqueue(new Callback<HomePlayingResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<HomePlayingResponse> call, @NonNull Response<HomePlayingResponse> response) {

                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                if (response.body().getNowPlayings() != null) {
                                    callback.onSuccess(response.body().getNowPlayings(), response.message(), response.body().getPage());
                                } else {
                                    callback.onFailure("No Results");
                                }
                            } else {
                                callback.onFailure("response.body() is null");
                            }
                        } else {
                            callback.onFailure(response.message() + " Error Code : " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<HomePlayingResponse> call, @NonNull Throwable t) {
                        callback.onFailure(t.getLocalizedMessage());
                    }
                });
    }
}
