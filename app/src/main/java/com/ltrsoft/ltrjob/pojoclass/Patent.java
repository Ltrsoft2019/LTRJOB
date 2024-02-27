package com.ltrsoft.ltrjob.pojoclass;

public class Patent {
    private String patent_id, patent_type_id, patent_decipline_id, patent_country_id, user_id, id;
    private String patent_number, patent_name, patent_granted_year, patent_valid_till_year;

    public Patent(String patent_id, String patent_type_id, String patent_decipline_id,
                  String patent_country_id,String user_id, String id, String patent_number,
                  String patent_name, String patent_granted_year, String patent_valid_till_year) {
        this.patent_id = patent_id;
        this.patent_type_id = patent_type_id;
        this.patent_decipline_id = patent_decipline_id;
        this.patent_country_id = patent_country_id;
        this.user_id = user_id;
        this.id = id;
        this.patent_number = patent_number;
        this.patent_name = patent_name;
        this.patent_granted_year = patent_granted_year;
        this.patent_valid_till_year = patent_valid_till_year;
    }

    public String getPatent_id() {
        return patent_id;
    }

    public void setPatent_id(String patent_id) {
        this.patent_id = patent_id;
    }

    public String getPatent_type_id() {
        return patent_type_id;
    }

    public void setPatent_type_id(String patent_type_id) {
        this.patent_type_id = patent_type_id;
    }

    public String getPatent_decipline_id() {
        return patent_decipline_id;
    }

    public void setPatent_decipline_id(String patent_decipline_id) {
        this.patent_decipline_id = patent_decipline_id;
    }

    public String getPatent_country_id() {
        return patent_country_id;
    }

    public void setPatent_country_id(String patent_country_id) {
        this.patent_country_id = patent_country_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatent_number() {
        return patent_number;
    }

    public void setPatent_number(String patent_number) {
        this.patent_number = patent_number;
    }

    public String getPatent_name() {
        return patent_name;
    }

    public void setPatent_name(String patent_name) {
        this.patent_name = patent_name;
    }

    public String getPatent_granted_year() {
        return patent_granted_year;
    }

    public void setPatent_granted_year(String patent_granted_year) {
        this.patent_granted_year = patent_granted_year;
    }

    public String getPatent_valid_till_year() {
        return patent_valid_till_year;
    }

    public void setPatent_valid_till_year(String patent_valid_till_year) {
        this.patent_valid_till_year = patent_valid_till_year;
    }
}