package com.ltrsoft.ltrjob.pojoclass;

public class Mcq_Type {

    private int mcq_type_id;
    private String mcq_type_name;

    public Mcq_Type(int mcq_type_id, String mcq_type_name) {
        this.mcq_type_id = mcq_type_id;
        this.mcq_type_name = mcq_type_name;
    }

    public int getMcq_type_id() {
        return mcq_type_id;
    }

    public void setMcq_type_id(int mcq_type_id) {
        this.mcq_type_id = mcq_type_id;
    }

    public String getMcq_type_name() {
        return mcq_type_name;
    }

    public void setMcq_type_name(String mcq_type_name) {
        this.mcq_type_name = mcq_type_name;
    }
}
