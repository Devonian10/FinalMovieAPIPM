package com.example.myapplicationiipertemuan9.adapters.clicklistener;

import com.example.myapplicationiipertemuan9.models.Favorite;
import com.example.myapplicationiipertemuan9.models.HomePlaying;
import com.example.myapplicationiipertemuan9.models.movie.Movie;
import com.example.myapplicationiipertemuan9.models.tv.TvShow;

public interface OnItemClickListener {
    void onClickItem(TvShow tvShow);
    void onClickItem(Movie movie);
    void onClickItem(Favorite favorite);
    void onClickItem(HomePlaying homePlaying);
}
