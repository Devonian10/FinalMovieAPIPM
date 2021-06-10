package com.example.myapplicationiipertemuan9.repository.callback;

import com.example.myapplicationiipertemuan9.models.HomePlaying;

import java.util.List;

public interface OnSearchMovieCallback {
    void onSuccess(List<HomePlaying> homePlayingList, int page, String message);

    void onFailure(String message);
}
