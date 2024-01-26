package com.ltrsoft.ltrjob.pojoclass;

public class City {
    private int id,city_id,distrct_id;
    private String city_name;

    public City(int id, int city_id, int distrct_id, String city_name) {
        this.id = id;
        this.city_id = city_id;
        this.distrct_id = distrct_id;
        this.city_name = city_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getDistrct_id() {
        return distrct_id;
    }

    public void setDistrct_id(int distrct_id) {
        this.distrct_id = distrct_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
}
