package com.ltrsoft.ltrjob.pojoclass;

public class News_Photo {
    private int news_photo_id,news_id;
    private String news_photo_path;

    public News_Photo(int news_photo_id, int news_id, String news_photo_path) {
        this.news_photo_id = news_photo_id;
        this.news_id = news_id;
    }

    public News_Photo(String newsPhotoPath) {
        this.news_photo_path = news_photo_path;

    }

    public int getNews_photo_id() {
        return news_photo_id;
    }

    public int getNews_id() {
        return news_id;
    }

    public String getNews_photo_path() {
        return news_photo_path;
    }
}
