package com.ltrsoft.ltrjob.pojoclass;

public class AwardLevel {
    private int id;
    private String award_level_name,award_level_id;

    public AwardLevel(int id, String award_level_id, String award_level_name) {
        this.id = id;
        this.award_level_id = award_level_id;
        this.award_level_name = award_level_name;
    }

    public AwardLevel(String awardLevelName) {
        this.award_level_name = award_level_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAward_level_id() {
        return award_level_id;
    }

    public void setAward_level_id(String award_level_id) {
        this.award_level_id = award_level_id;
    }

    public String getAward_level_name() {
        return award_level_name;
    }

    public void setAward_level_name(String award_level_name) {
        this.award_level_name = award_level_name;
    }
}
