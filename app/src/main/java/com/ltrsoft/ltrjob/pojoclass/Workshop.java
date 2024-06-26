package com.ltrsoft.ltrjob.pojoclass;

public class Workshop {
    private String id,workshop_type_id,user_id;
    private String workshop_name,workshop_venue,workshop_level,workshop_date,workshop_id;

    public Workshop(String id, String workshop_id, String workshop_type_id, String user_id, String workshop_name, String workshop_venue, String workshop_level, String workshop_date) {
        this.id = id;
        this.workshop_id = workshop_id;
        this.workshop_type_id = workshop_type_id;
        this.user_id = user_id;
        this.workshop_name = workshop_name;
        this.workshop_venue = workshop_venue;
        this.workshop_level = workshop_level;
        this.workshop_date = workshop_date;
    }

    public Workshop(String workshopName, String workshopVenue, String workshopLevel, String workshopDate) {
        this.workshop_name = workshopName;
        this.workshop_venue = workshopVenue;
        this.workshop_level = workshopLevel;
        this.workshop_date = workshopDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkshop_type_id() {
        return workshop_type_id;
    }

    public void setWorkshop_type_id(String workshop_type_id) {
        this.workshop_type_id = workshop_type_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getWorkshop_id() {
        return workshop_id;
    }

    public void setWorkshop_id(String workshop_id) {
        this.workshop_id = workshop_id;
    }
    public String getWorkshop_name() {
        return workshop_name;
    }

    public void setWorkshop_name(String workshop_name) {
        this.workshop_name = workshop_name;
    }

    public String getWorkshop_venue() {
        return workshop_venue;
    }

    public void setWorkshop_venue(String workshop_venue) {
        this.workshop_venue = workshop_venue;
    }

    public String getWorkshop_level() {
        return workshop_level;
    }

    public void setWorkshop_level(String workshop_level) {
        this.workshop_level = workshop_level;
    }

    public String getWorkshop_date() {
        return workshop_date;
    }

    public void setWorkshop_date(String workshop_date) {
        this.workshop_date = workshop_date;
    }
}
