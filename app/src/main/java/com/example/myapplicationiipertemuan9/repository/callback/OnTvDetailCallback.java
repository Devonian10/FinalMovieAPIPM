package com.example.myapplicationiipertemuan9.repository.callback;

import com.example.myapplicationiipertemuan9.models.TvShowPlaying;
import com.example.myapplicationiipertemuan9.models.tv.TvShow;
import java.util.*;
public interface OnTvDetailCallback {
    void onSuccess (TvShowPlaying tvShow, String message);

    void onFailure (String message);
}
