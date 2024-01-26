package com.ltrsoft.ltrjob.pojoclass;

public class Interpersonal_skill_type {
    private int id,interpersonal_skill_type_id;
    private String interpersonal_skill_type_name;

    public Interpersonal_skill_type(int id, int interpersonal_skill_type_id, String interpersonal_skill_type_name) {
        this.id = id;
        this.interpersonal_skill_type_id = interpersonal_skill_type_id;
        this.interpersonal_skill_type_name = interpersonal_skill_type_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInterpersonal_skill_type_id() {
        return interpersonal_skill_type_id;
    }

    public void setInterpersonal_skill_type_id(int interpersonal_skill_type_id) {
        this.interpersonal_skill_type_id = interpersonal_skill_type_id;
    }

    public String getInterpersonal_skill_type_name() {
        return interpersonal_skill_type_name;
    }

    public void setInterpersonal_skill_type_name(String interpersonal_skill_type_name) {
        this.interpersonal_skill_type_name = interpersonal_skill_type_name;
    }
}
