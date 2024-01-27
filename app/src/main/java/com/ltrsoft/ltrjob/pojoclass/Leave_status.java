package com.ltrsoft.ltrjob.pojoclass;

public class Leave_status {
    private int id,leave_status_id;
    private String leave_status_name;

    public Leave_status(int id, int leave_status_id, String leave_status_name) {
        this.id = id;
        this.leave_status_id = leave_status_id;
        this.leave_status_name = leave_status_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeave_status_id() {
        return leave_status_id;
    }

    public void setLeave_status_id(int leave_status_id) {
        this.leave_status_id = leave_status_id;
    }

    public String getLeave_status_name() {
        return leave_status_name;
    }

    public void setLeave_status_name(String leave_status_name) {
        this.leave_status_name = leave_status_name;
    }
}
