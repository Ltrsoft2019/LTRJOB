package com.ltrsoft.ltrjob.pojoclass;

public class State {
    private String state_name;
    private int id,state_id,country_id;


    public State(String state_name, int id, int state_id, int country_id) {
        this.state_name = state_name;
        this.id = id;
        this.state_id = state_id;
        this.country_id = country_id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }
}
