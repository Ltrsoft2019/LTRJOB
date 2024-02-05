package com.ltrsoft.ltrjob.pojoclass;

public class City {
    private String id, distrct_id;
    private String city_name, city_id;

    public City(String city_id, String distrct_id, String city_name) {
        this.city_id = city_id;
        this.distrct_id = distrct_id;
        this.city_name = city_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDistrct_id() {
        return distrct_id;
    }

    public void setDistrct_id(String distrct_id) {
        this.distrct_id = distrct_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }
}