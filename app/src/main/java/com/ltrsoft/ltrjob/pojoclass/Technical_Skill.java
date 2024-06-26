package com.ltrsoft.ltrjob.pojoclass;

public class Technical_Skill {
    private String id,technical_skill_id,technical_type_id;
    private String technical_skill_name;

    public Technical_Skill(String id, String technical_skill_id, String technical_type_id, String technical_skill_name) {
        this.id = id;
        this.technical_skill_id = technical_skill_id;
        this.technical_type_id = technical_type_id;
        this.technical_skill_name = technical_skill_name;
    }

    public Technical_Skill(String technicalSkillName) {
        this.technical_skill_name=technicalSkillName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTechnical_skill_id() {
        return technical_skill_id;
    }

    public void setTechnical_skill_id(String technical_skill_id) {
        this.technical_skill_id = technical_skill_id;
    }

    public String getTechnical_type_id() {
        return technical_type_id;
    }

    public void setTechnical_type_id(String technical_type_id) {
        this.technical_type_id = technical_type_id;
    }

    public String getTechnical_skill_name() {
        return technical_skill_name;
    }

    public void setTechnical_skill_name(String technical_skill_name) {
        this.technical_skill_name = technical_skill_name;
    }
}
