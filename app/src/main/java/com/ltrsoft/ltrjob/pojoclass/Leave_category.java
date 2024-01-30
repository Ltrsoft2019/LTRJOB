package com.ltrsoft.ltrjob.pojoclass;

public class Leave_category {
    private int id;
    private String leave_category_name,leave_category_id;

    public Leave_category(int id, String leave_category_id, String leave_category_name) {
        this.id = id;
        this.leave_category_id = leave_category_id;
        this.leave_category_name = leave_category_name;
    }

    public Leave_category(String leaveCategoryName) {
        this.leave_category_name = leave_category_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeave_category_id() {
        return leave_category_id;
    }

    public void setLeave_category_id(String leave_category_id) {
        this.leave_category_id = leave_category_id;
    }

    public String getLeave_category_name() {
        return leave_category_name;
    }

    public void setLeave_category_name(String leave_category_name) {
        this.leave_category_name = leave_category_name;
    }
}
