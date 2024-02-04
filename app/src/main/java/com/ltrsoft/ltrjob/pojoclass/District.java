package com.ltrsoft.ltrjob.pojoclass;

public class District {
    private String id,state_id;
    private String district_name,district_id;

    public District(String state_id, String district_name, String district_id) {
        this.state_id = state_id;
        this.district_name = district_name;
        this.district_id = district_id;
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

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }
}
