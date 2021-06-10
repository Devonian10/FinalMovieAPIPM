package com.example.myapplicationiipertemuan9.repository.callback;

import com.example.myapplicationiipertemuan9.models.HomePlaying;

import java.util.List;

public interface OnMoviePlayingCallback {
    void onSuccess(int page, List<HomePlaying> homePlayingList, String message);

    void onFailure(String message);
}
