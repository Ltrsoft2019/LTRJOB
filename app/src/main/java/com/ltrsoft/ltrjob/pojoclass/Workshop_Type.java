package com.ltrsoft.ltrjob.pojoclass;

public class Workshop_Type {
    private int id,workshop_type_id;
    private String workshop_type_name;

    public Workshop_Type(int id, int workshop_type_id, String workshop_type_name) {
        this.id = id;
        this.workshop_type_id = workshop_type_id;
        this.workshop_type_name = workshop_type_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkshop_type_id() {
        return workshop_type_id;
    }

    public void setWorkshop_type_id(int workshop_type_id) {
        this.workshop_type_id = workshop_type_id;
    }

    public String getWorkshop_type_name() {
        return workshop_type_name;
    }

    public void setWorkshop_type_name(String workshop_type_name) {
        this.workshop_type_name = workshop_type_name;
    }
}
