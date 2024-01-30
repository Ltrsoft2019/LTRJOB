package com.ltrsoft.ltrjob.pojoclass;

public class Award {
    private int id,award_level_id,award_category_id,award_type_id;
    private String award_name,award_given_by,award_date_recieved,award_venue,user_id;

    public Award(int id,String user_id, int award_level_id, int award_category_id, int award_type_id, String award_name, String award_given_by, String award_date_recieved, String award_venue) {
        this.id = id;
        this.user_id=user_id;
        this.award_level_id = award_level_id;
        this.award_category_id = award_category_id;
        this.award_type_id = award_type_id;
        this.award_name = award_name;
        this.award_given_by = award_given_by;
        this.award_date_recieved = award_date_recieved;
        this.award_venue = award_venue;
    }

    public Award(String awardName, String awardGivenBy, String awardDateRecieved, String awardVenue) {
        this.award_name = award_name;
        this.award_given_by = award_given_by;
        this.award_date_recieved = award_date_recieved;
        this.award_venue = award_venue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAward_level_id() {
        return award_level_id;
    }

    public void setAward_level_id(int award_level_id) {
        this.award_level_id = award_level_id;
    }

    public int getAward_category_id() {
        return award_category_id;
    }

    public void setAward_category_id(int award_category_id) {
        this.award_category_id = award_category_id;
    }

    public int getAward_type_id() {
        return award_type_id;
    }

    public void setAward_type_id(int award_type_id) {
        this.award_type_id = award_type_id;
    }

    public String getAward_name() {
        return award_name;
    }

    public void setAward_name(String award_name) {
        this.award_name = award_name;
    }

    public String getAward_given_by() {
        return award_given_by;
    }

    public void setAward_given_by(String award_given_by) {
        this.award_given_by = award_given_by;
    }

    public String getAward_date_recieved() {
        return award_date_recieved;
    }

    public void setAward_date_recieved(String award_date_recieved) {
        this.award_date_recieved = award_date_recieved;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAward_venue() {
        return award_venue;
    }

    public void setAward_venue(String award_venue) {
        this.award_venue = award_venue;
    }
}
