package com.example.myapplicationiipertemuan9.network;

import java.util.Locale;

public class Const {
    public static final String MOVIE_BASE_URL = "http://api.themoviedb.org/3/movie/";
    public static final String TVSHOW_BASE_URL = "http://api.themoviedb.org/3/tv/";
    public static final String BASE_URL = "http://api.themoviedb.org/3/movie/";
    public static final String BASE_URL_DETAIL = "http://api.themoviedb.org/3/";
    public static final String API_KEY = "dfd764ba46baefc073431b2c19a16b4b";
    public static final String IMG_URL_ORI = "https://image.tmdb.org/t/p/original/";
    public static final String IMG_URL_200 = "https://image.tmdb.org/t/p/w200/";
    public static final String IMG_URL_300 = "https://image.tmdb.org/t/p/w300/";
    public static final String IMG_URL_500 = "https://image.tmdb.org/t/p/w500/";
    public static final String IMG_URL = "https://image.tmdb.org/t/p/";
    public static String getLang() {
        switch (Locale.getDefault().toString()) {
            case "in_ID":
                return "id-ID";
            default:
                return "en-US";
        }
    }
}
