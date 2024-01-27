package com.ltrsoft.ltrjob.pojoclass;

public class User_Interpersonal_Skills {
    private int id,user_interpersonal_skill_id,user_id,interpersonal_skill_id;

    public User_Interpersonal_Skills(int id, int user_interpersonal_skill_id, int user_id, int interpersonal_skill_id) {
        this.id = id;
        this.user_interpersonal_skill_id = user_interpersonal_skill_id;
        this.user_id = user_id;
        this.interpersonal_skill_id = interpersonal_skill_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_interpersonal_skill_id() {
        return user_interpersonal_skill_id;
    }

    public void setUser_interpersonal_skill_id(int user_interpersonal_skill_id) {
        this.user_interpersonal_skill_id = user_interpersonal_skill_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getInterpersonal_skill_id() {
        return interpersonal_skill_id;
    }

    public void setInterpersonal_skill_id(int interpersonal_skill_id) {
        this.interpersonal_skill_id = interpersonal_skill_id;
    }
}
