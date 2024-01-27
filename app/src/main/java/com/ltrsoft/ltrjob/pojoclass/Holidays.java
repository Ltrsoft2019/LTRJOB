package com.ltrsoft.ltrjob.pojoclass;

public class Holidays {
    private int id,holidays_id;

    public Holidays(int id, int holidays_id, String holidays_title, String holidays_description, String holidays_start_date, String holidays_end_date) {
        this.id = id;
        this.holidays_id = holidays_id;
        this.holidays_title = holidays_title;
        this.holidays_description = holidays_description;
        this.holidays_start_date = holidays_start_date;
        this.holidays_end_date = holidays_end_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHolidays_id() {
        return holidays_id;
    }

    public void setHolidays_id(int holidays_id) {
        this.holidays_id = holidays_id;
    }

    public String getHolidays_title() {
        return holidays_title;
    }

    public void setHolidays_title(String holidays_title) {
        this.holidays_title = holidays_title;
    }

    public String getHolidays_description() {
        return holidays_description;
    }

    public void setHolidays_description(String holidays_description) {
        this.holidays_description = holidays_description;
    }

    public String getHolidays_start_date() {
        return holidays_start_date;
    }

    public void setHolidays_start_date(String holidays_start_date) {
        this.holidays_start_date = holidays_start_date;
    }

    public String getHolidays_end_date() {
        return holidays_end_date;
    }

    public void setHolidays_end_date(String holidays_end_date) {
        this.holidays_end_date = holidays_end_date;
    }

    private String holidays_title,holidays_description,holidays_start_date,holidays_end_date;
}
