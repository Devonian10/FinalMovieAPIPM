package com.example.myapplicationiipertemuan9.repository;

import android.app.Service;

import androidx.annotation.NonNull;
import androidx.annotation.*;

import com.example.myapplicationiipertemuan9.models.TvShowPlaying;
import com.example.myapplicationiipertemuan9.models.TvShowPlayingResponse;
import com.example.myapplicationiipertemuan9.models.tv.TvShow;
import com.example.myapplicationiipertemuan9.network.Const;
import com.example.myapplicationiipertemuan9.repository.callback.OnSearchCallback;
import com.example.myapplicationiipertemuan9.repository.callback.OnTvDetailCallback;
import com.example.myapplicationiipertemuan9.repository.callback.OnTvShowCallback;
import com.example.myapplicationiipertemuan9.network.TvShowApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TvShowRepository {
    private static TvShowRepository repository;
    private TvShowApiInterface service;

    private TvShowRepository(TvShowApiInterface service) {
        this.service = service;
    }

    public static TvShowRepository getInstance() {
        if (repository == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Const.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            repository = new TvShowRepository(retrofit.create(TvShowApiInterface.class));
        }
        return repository;
    }

    public void getTvShow(String sortBy, int page, final OnTvShowCallback callback) {
        service.getTvPlaying(sortBy, Const.API_KEY, Const.getLang(), page)
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

    public void getTvDetail(int id, final OnTvDetailCallback callback) {
        service.getDetail(id, Const.API_KEY, Const.getLang())
                .enqueue(new Callback<TvShow>() {
                    @Override
                    public void onResponse(@NonNull Call<TvShow> call, @NonNull Response<TvShow> response) {
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
                    public void onFailure(@NonNull Call<TvShow> call, @NonNull Throwable t) {
                        callback.onFailure(t.getLocalizedMessage());
                    }
                });
    }

    public void search(String query, int page, final OnSearchCallback callback) {
        service.search(Const.API_KEY, query, Const.getLang(), page)
                .enqueue(new Callback<TvShowPlayingResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<TvShowPlayingResponse> call, @NonNull Response<TvShowPlayingResponse> response) {

                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                if (response.body().getTvPlaying() != null) {
                                    callback.onSuccess(response.body().getTvPlaying(), response.message(), response.body().getPage());
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
                    public void onFailure(@NonNull Call<TvShowPlayingResponse> call, @NonNull Throwable t) {
                        callback.onFailure(t.getLocalizedMessage());
                    }
                });
    }
}
