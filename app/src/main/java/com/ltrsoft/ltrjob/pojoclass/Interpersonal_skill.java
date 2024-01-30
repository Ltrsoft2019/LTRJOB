package com.ltrsoft.ltrjob.pojoclass;

public class Interpersonal_skill {
    private int id,interpersonal_skill_type_id;
    private String interpersonal_skill_name,interpersonal_skill_id;

    public Interpersonal_skill(int id, String interpersonal_skill_id, int interpersonal_skill_type_id, String interpersonal_skill_name) {
        this.id = id;
        this.interpersonal_skill_id = interpersonal_skill_id;
        this.interpersonal_skill_type_id = interpersonal_skill_type_id;
        this.interpersonal_skill_name = interpersonal_skill_name;
    }

    public Interpersonal_skill(String interpersonalSkillName) {
        this.interpersonal_skill_name = interpersonal_skill_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInterpersonal_skill_id() {
        return interpersonal_skill_id;
    }

    public void setInterpersonal_skill_id(String interpersonal_skill_id) {
        this.interpersonal_skill_id = interpersonal_skill_id;
    }

    public int getInterpersonal_skill_type_id() {
        return interpersonal_skill_type_id;
    }

    public void setInterpersonal_skill_type_id(int interpersonal_skill_type_id) {
        this.interpersonal_skill_type_id = interpersonal_skill_type_id;
    }

    public String getInterpersonal_skill_name() {
        return interpersonal_skill_name;
    }

    public void setInterpersonal_skill_name(String interpersonal_skill_name) {
        this.interpersonal_skill_name = interpersonal_skill_name;
    }
}
