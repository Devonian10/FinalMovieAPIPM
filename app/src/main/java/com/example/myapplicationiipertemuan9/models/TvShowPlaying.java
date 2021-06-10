package com.example.myapplicationiipertemuan9.models;

import com.example.myapplicationiipertemuan9.network.Const;
import com.example.myapplicationiipertemuan9.network.ImageSize;
import com.google.gson.annotations.SerializedName;

public class TvShowPlaying {
    @SerializedName("id")
    private String id;
    @SerializedName("overview")
    private String overview;

    @SerializedName("vote_average")
    private float voteAverage;
    @SerializedName("name")
    private String title;

    @SerializedName("last_air_date")
    private String lastAirDate;

    @SerializedName("first_air_date")
    private String firstAirDate;



    @SerializedName("number_of_seasons")
    private int numberOfseasons;

    @SerializedName("vote_count")
    private int voteCount;


    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("number_of_episodes")
    private int numberOfepisodes;
    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("poster_path")
    private String posterPath2;

    public TvShowPlaying(){

    }public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }
    public int getNumberOfseasons() {
        return numberOfseasons;
    }

    public void setNumberOfseasons(int numberOfseasons) {
        this.numberOfseasons = numberOfseasons;
    }
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath(ImageSize size) {
        return Const.IMG_URL + size.getValue() + posterPath;
    }
    public String getPosterPath2(){
        return posterPath2;
    }
    public void setPosterPath2(String posterPath2) {
        this.posterPath2 = posterPath2;
    }
    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }
    public void setLastAirDate(String lastAirDate) {
        this.lastAirDate = lastAirDate;
    }

    public String getLastAirDate() {
        return lastAirDate;
    }

    public int getNumberOfepisodes() {
        return numberOfepisodes;
    }

    public void setNumberOfepisodes(int numberOfepisodes) {
        this.numberOfepisodes = numberOfepisodes;
    }
    public String getBackdropPath(ImageSize size) {
        return Const.IMG_URL + size.getValue() + backdropPath;
    }

}

