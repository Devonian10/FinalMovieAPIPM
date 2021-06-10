package com.example.myapplicationiipertemuan9.repository.callback;

import com.example.myapplicationiipertemuan9.models.HomePlaying;
import com.example.myapplicationiipertemuan9.models.TvShowPlaying;
import com.example.myapplicationiipertemuan9.models.tv.TvShow;

import java.util.List;

public interface OnSearchCallback {
    void onSuccess(List<TvShowPlaying> tvShowList, String message, int page);

    void onFailure(String message);
}
