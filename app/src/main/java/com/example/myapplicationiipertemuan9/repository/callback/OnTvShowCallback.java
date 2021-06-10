package com.example.myapplicationiipertemuan9.repository.callback;

import com.example.myapplicationiipertemuan9.models.TvShowPlaying;
import com.example.myapplicationiipertemuan9.models.tv.TvShow;

import java.util.List;

public interface OnTvShowCallback {
    void onSuccess(int page, List<TvShowPlaying> tvShowList);

    void onFailure(String message);
}
