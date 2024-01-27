package com.ltrsoft.ltrjob.pojoclass;

public class News_Category {
    private int news_category_id;
    public String news_category_name;

    public News_Category(int news_category_id, String news_category_name) {
        this.news_category_id = news_category_id;
        this.news_category_name = news_category_name;
    }

    public int getNews_category_id() {
        return news_category_id;
    }

    public void setNews_category_id(int news_category_id) {
        this.news_category_id = news_category_id;
    }

    public String getNews_category_name() {
        return news_category_name;
    }

    public void setNews_category_name(String news_category_name) {
        this.news_category_name = news_category_name;
    }
}
