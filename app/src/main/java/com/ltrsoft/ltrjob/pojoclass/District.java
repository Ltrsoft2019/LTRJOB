package com.ltrsoft.ltrjob.pojoclass;

public class District {
    private int id,district_id,state_id;
    private String district_name;

    public District(int id, int district_id, int state_id, String district_name) {
        this.id = id;
        this.district_id = district_id;
        this.state_id = state_id;
        this.district_name = district_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }
}
