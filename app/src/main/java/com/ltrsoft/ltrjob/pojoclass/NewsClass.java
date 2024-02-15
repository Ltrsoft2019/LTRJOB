package com.ltrsoft.ltrjob.pojoclass;

public class NewsClass {
    String news_title, news_description, news_date, news_resource, news_photo_path;

    public NewsClass(String news_title, String news_description, String news_date, String news_resource, String news_photo_path) {
        this.news_title = news_title;
        this.news_description = news_description;
        this.news_date = news_date;
        this.news_resource = news_resource;
        this.news_photo_path = news_photo_path;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_description() {
        return news_description;
    }

    public void setNews_description(String news_description) {
        this.news_description = news_description;
    }

    public String getNews_date() {
        return news_date;
    }

    public void setNews_date(String news_date) {
        this.news_date = news_date;
    }

    public String getNews_resource() {
        return news_resource;
    }

    public void setNews_resource(String news_resource) {
        this.news_resource = news_resource;
    }

    public String getNews_photo_path() {
        return news_photo_path;
    }

    public void setNews_photo_path(String news_photo_path) {
        this.news_photo_path = news_photo_path;
    }
}