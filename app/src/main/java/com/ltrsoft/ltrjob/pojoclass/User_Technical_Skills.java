package com.ltrsoft.ltrjob.pojoclass;

public class User_Technical_Skills {

    private int id,user_technical_skill_id,user_id,technical_skill_id;

    public User_Technical_Skills(int id, int user_technical_skill_id, int user_id, int technical_skill_id) {
        this.id = id;
        this.user_technical_skill_id = user_technical_skill_id;
        this.user_id = user_id;
        this.technical_skill_id = technical_skill_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_technical_skill_id() {
        return user_technical_skill_id;
    }

    public void setUser_technical_skill_id(int user_technical_skill_id) {
        this.user_technical_skill_id = user_technical_skill_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTechnical_skill_id() {
        return technical_skill_id;
    }

    public void setTechnical_skill_id(int technical_skill_id) {
        this.technical_skill_id = technical_skill_id;
    }
}
