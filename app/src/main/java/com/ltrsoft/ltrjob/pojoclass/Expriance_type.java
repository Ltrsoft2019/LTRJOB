package com.ltrsoft.ltrjob.pojoclass;

public class Expriance_type {
    private int id,experiance_type_id;
    private String experiance_type_name;

    public Expriance_type(int id, int experiance_type_id, String experiance_type_name) {
        this.id = id;
        this.experiance_type_id = experiance_type_id;
        this.experiance_type_name = experiance_type_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExperiance_type_id() {
        return experiance_type_id;
    }

    public void setExperiance_type_id(int experiance_type_id) {
        this.experiance_type_id = experiance_type_id;
    }

    public String getExperiance_type_name() {
        return experiance_type_name;
    }

    public void setExperiance_type_name(String experiance_type_name) {
        this.experiance_type_name = experiance_type_name;
    }
}
