package com.ltrsoft.ltrjob.pojoclass;

public class Mcq_Option {
    private int mcq_option_id,mcq_id,id;
    private String mcq_option_name;

    public Mcq_Option(int mcq_option_id, int mcq_id, int id, String mcq_option_name) {
        this.mcq_option_id = mcq_option_id;
        this.mcq_id = mcq_id;
        this.id = id;
        this.mcq_option_name = mcq_option_name;
    }

    public int getMcq_option_id() {
        return mcq_option_id;
    }

    public void setMcq_option_id(int mcq_option_id) {
        this.mcq_option_id = mcq_option_id;
    }

    public int getMcq_id() {
        return mcq_id;
    }

    public void setMcq_id(int mcq_id) {
        this.mcq_id = mcq_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMcq_option_name() {
        return mcq_option_name;
    }

    public void setMcq_option_name(String mcq_option_name) {
        this.mcq_option_name = mcq_option_name;
    }
}
