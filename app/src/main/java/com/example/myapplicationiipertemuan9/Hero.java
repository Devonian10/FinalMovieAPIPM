package com.example.myapplicationiipertemuan9;

public class Hero {

    private String name;
    private String summary;
    private String birthday;
    private String constellation;
    private String affiliates;
    private String vision;
    private int photo;

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getPhoto() {
        return photo;
    }
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getConstellation() {
        return constellation;
    }
    public String getAffiliates() {
        return affiliates;
    }

    public void setAffiliates(String affiliates) {
        this.affiliates = affiliates;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }
}
