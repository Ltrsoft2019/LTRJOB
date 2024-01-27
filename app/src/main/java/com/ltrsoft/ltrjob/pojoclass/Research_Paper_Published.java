package com.ltrsoft.ltrjob.pojoclass;

public class Research_Paper_Published {
    private int research_paper_published_in_id,user_id,id;
    private String h_index;

    public Research_Paper_Published(int research_paper_published_in_id, int user_id, int id, String h_index) {
        this.research_paper_published_in_id = research_paper_published_in_id;
        this.user_id = user_id;
        this.id = id;
        this.h_index = h_index;
    }

    public int getResearch_paper_published_in_id() {
        return research_paper_published_in_id;
    }

    public void setResearch_paper_published_in_id(int research_paper_published_in_id) {
        this.research_paper_published_in_id = research_paper_published_in_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getH_index() {
        return h_index;
    }

    public void setH_index(String h_index) {
        this.h_index = h_index;
    }
}
