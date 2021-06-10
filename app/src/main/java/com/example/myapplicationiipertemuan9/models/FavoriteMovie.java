package com.example.myapplicationiipertemuan9.models;

;
import java.io.Serializable;

public class FavoriteMovie implements Serializable {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "img_path")
    private String imgPath;

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @ColumnInfo(name = "rate")
    private Float rate;



    public FavoriteMovie(){

    }

    public FavoriteMovie(int id, String title, String imgPath, Float rate){
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.rate = rate;
    }
}
