package com.ltrsoft.ltrjob.pojoclass;

public class AwardType {
    private int id;
    private String award_type_name,award_type_id;

    public AwardType(int id, String award_type_id, String award_type_name) {
        this.id = id;
        this.award_type_id = award_type_id;
        this.award_type_name = award_type_name;
    }

    public AwardType(String awardTypeName) {
        this.award_type_name = award_type_name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAward_type_id() {
        return award_type_id;
    }

    public void setAward_type_id(String award_type_id) {
        this.award_type_id = award_type_id;
    }

    public String getAward_type_name() {
        return award_type_name;
    }

    public void setAward_type_name(String award_type_name) {
        this.award_type_name = award_type_name;
    }
}
