package com.ltrsoft.ltrjob.pojoclass;

public class AwardCategory {
    private int id,award_catogery_id;
    private String award_catogery_name;

    public AwardCategory(int id, int award_catogery_id, String award_catogery_name) {
        this.id = id;
        this.award_catogery_id = award_catogery_id;
        this.award_catogery_name = award_catogery_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAward_catogery_id() {
        return award_catogery_id;
    }

    public void setAward_catogery_id(int award_catogery_id) {
        this.award_catogery_id = award_catogery_id;
    }

    public String getAward_catogery_name() {
        return award_catogery_name;
    }

    public void setAward_catogery_name(String award_catogery_name) {
        this.award_catogery_name = award_catogery_name;
    }
}
