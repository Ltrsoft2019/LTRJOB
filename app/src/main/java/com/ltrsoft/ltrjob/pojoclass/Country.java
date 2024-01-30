package com.ltrsoft.ltrjob.pojoclass;

public class Country {
    private int id;
    private String country_name,country_id;

    public Country(int id, String country_id, String country_name) {
        this.id = id;
        this.country_id = country_id;
        this.country_name = country_name;
    }

    public Country(String countryName) {
        this.country_name = country_name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}
