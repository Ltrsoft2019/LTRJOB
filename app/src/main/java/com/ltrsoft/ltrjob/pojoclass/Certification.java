package com.ltrsoft.ltrjob.pojoclass;

public class Certification {
    private int id,certification_id,user_id;
    private String certification_title,certification_year,certification_from,certification_number;

    public Certification(int id, int certification_id, int user_id, String certification_title, String certification_year, String certification_from, String certification_number) {
        this.id = id;
        this.certification_id = certification_id;
        this.user_id = user_id;
        this.certification_title = certification_title;
        this.certification_year = certification_year;
        this.certification_from = certification_from;
        this.certification_number = certification_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCertification_id() {
        return certification_id;
    }

    public void setCertification_id(int certification_id) {
        this.certification_id = certification_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCertification_title() {
        return certification_title;
    }

    public void setCertification_title(String certification_title) {
        this.certification_title = certification_title;
    }

    public String getCertification_year() {
        return certification_year;
    }

    public void setCertification_year(String certification_year) {
        this.certification_year = certification_year;
    }

    public String getCertification_from() {
        return certification_from;
    }

    public void setCertification_from(String certification_from) {
        this.certification_from = certification_from;
    }

    public String getCertification_number() {
        return certification_number;
    }

    public void setCertification_number(String certification_number) {
        this.certification_number = certification_number;
    }
}
