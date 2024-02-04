package com.ltrsoft.ltrjob.pojoclass;

public class State {
    private String state_name;
    private String id,state_id,country_id;

    public State(String state_name, String state_id, String country_id) {
        this.state_name = state_name;
        this.state_id = state_id;
        this.country_id = country_id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }
}
