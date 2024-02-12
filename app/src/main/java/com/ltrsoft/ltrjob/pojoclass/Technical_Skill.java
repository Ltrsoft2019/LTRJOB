package com.ltrsoft.ltrjob.pojoclass;

public class Technical_Skill {
    private int id,technical_skill_id,technical_type_id;
    private String technical_skill_name;

    public Technical_Skill(int id, int technical_skill_id, int technical_type_id, String technical_skill_name) {
        this.id = id;
        this.technical_skill_id = technical_skill_id;
        this.technical_type_id = technical_type_id;
        this.technical_skill_name = technical_skill_name;
    }

    public Technical_Skill(String technicalSkillName) {
        this.technical_skill_name=technicalSkillName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTechnical_skill_id() {
        return technical_skill_id;
    }

    public void setTechnical_skill_id(int technical_skill_id) {
        this.technical_skill_id = technical_skill_id;
    }

    public int getTechnical_type_id() {
        return technical_type_id;
    }

    public void setTechnical_type_id(int technical_type_id) {
        this.technical_type_id = technical_type_id;
    }

    public String getTechnical_skill_name() {
        return technical_skill_name;
    }

    public void setTechnical_skill_name(String technical_skill_name) {
        this.technical_skill_name = technical_skill_name;
    }
}
