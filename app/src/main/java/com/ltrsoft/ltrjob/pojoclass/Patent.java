package com.ltrsoft.ltrjob.pojoclass;

public class Patent {
    private int patent_id,patent_type_id,patent_decipline_id,patent_country_id,user_id,id;
    private String patent_number,patent_name,patent_granted_year,patent_valid_till_year;

    public Patent(int patent_id, int patent_type_id, int patent_decipline_id, int patent_country_id, int user_id, int id, String patent_number, String patent_name, String patent_granted_year, String patent_valid_till_year) {
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

    public int getPatent_id() {
        return patent_id;
    }

    public void setPatent_id(int patent_id) {
        this.patent_id = patent_id;
    }

    public int getPatent_type_id() {
        return patent_type_id;
    }

    public void setPatent_type_id(int patent_type_id) {
        this.patent_type_id = patent_type_id;
    }

    public int getPatent_decipline_id() {
        return patent_decipline_id;
    }

    public void setPatent_decipline_id(int patent_decipline_id) {
        this.patent_decipline_id = patent_decipline_id;
    }

    public int getPatent_country_id() {
        return patent_country_id;
    }

    public void setPatent_country_id(int patent_country_id) {
        this.patent_country_id = patent_country_id;
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
