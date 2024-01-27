package com.ltrsoft.ltrjob.pojoclass;

public class Research_Category {
    private int research_category_id;
    private String research_category_name;

    public Research_Category(int research_category_id, String research_category_name) {
        this.research_category_id = research_category_id;
        this.research_category_name = research_category_name;
    }

    public int getResearch_category_id() {
        return research_category_id;
    }

    public void setResearch_category_id(int research_category_id) {
        this.research_category_id = research_category_id;
    }

    public String getResearch_category_name() {
        return research_category_name;
    }

    public void setResearch_category_name(String research_category_name) {
        this.research_category_name = research_category_name;
    }
}
