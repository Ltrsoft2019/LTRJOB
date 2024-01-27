package com.ltrsoft.ltrjob.pojoclass;

public class News {
    private int news_id,news_category_id,id;
    private String news_title,news_description,news_resource;

    public News(int news_id, int news_category_id, int id, String news_title, String news_description, String news_resource) {
        this.news_id = news_id;
        this.news_category_id = news_category_id;
        this.id = id;
        this.news_title = news_title;
        this.news_description = news_description;
        this.news_resource = news_resource;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public int getNews_category_id() {
        return news_category_id;
    }

    public void setNews_category_id(int news_category_id) {
        this.news_category_id = news_category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNews_resource() {
        return news_resource;
    }

    public void setNews_resource(String news_resource) {
        this.news_resource = news_resource;
    }
}
