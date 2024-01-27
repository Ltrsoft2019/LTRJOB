package com.ltrsoft.ltrjob.pojoclass;

public class Qualification_Level {
    private int qualification_level_id;
    private String qualification_level_name;

    public Qualification_Level(int qualification_level_id, String qualification_level_name) {
        this.qualification_level_id = qualification_level_id;
        this.qualification_level_name = qualification_level_name;
    }

    public int getQualification_level_id() {
        return qualification_level_id;
    }

    public void setQualification_level_id(int qualification_level_id) {
        this.qualification_level_id = qualification_level_id;
    }

    public String getQualification_level_name() {
        return qualification_level_name;
    }

    public void setQualification_level_name(String qualification_level_name) {
        this.qualification_level_name = qualification_level_name;
    }
}
