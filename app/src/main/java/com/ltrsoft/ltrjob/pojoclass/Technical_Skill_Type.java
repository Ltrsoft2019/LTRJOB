package com.ltrsoft.ltrjob.pojoclass;

public class Technical_Skill_Type {

    private int technical_skill_type_id;
    private String technical_skill_type_name;


    public Technical_Skill_Type(int technical_skill_type_id, String technical_skill_type_name) {
        this.technical_skill_type_id = technical_skill_type_id;
        this.technical_skill_type_name = technical_skill_type_name;
    }

    public int getTechnical_skill_type_id() {
        return technical_skill_type_id;
    }

    public void setTechnical_skill_type_id(int technical_skill_type_id) {
        this.technical_skill_type_id = technical_skill_type_id;
    }

    public String getTechnical_skill_type_name() {
        return technical_skill_type_name;
    }

    public void setTechnical_skill_type_name(String technical_skill_type_name) {
        this.technical_skill_type_name = technical_skill_type_name;
    }
}
