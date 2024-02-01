package com.ltrsoft.ltrjob.pojoclass;

public class News_Photo {
    private String news_photo_path, news_id;

    public News_Photo(String news_photo_path) {
        this.news_photo_path = news_photo_path;
    }


    public String getNews_photo_path() {
        return news_photo_path;
    }

    public void setNews_photo_path(String news_photo_path) {
        this.news_photo_path = news_photo_path;
    }

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }
}
