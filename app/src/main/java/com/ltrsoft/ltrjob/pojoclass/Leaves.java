package com.ltrsoft.ltrjob.pojoclass;

public class Leaves {
    private int id,user_role_id,leave_category_id,leave_status_id;
    private String leaves_start_date,leaves_end_date,leaves_duration,leaves_reason,leaves_id;

    public Leaves(int id, String leaves_id, int user_role_id, int leave_category_id, int leave_status_id, String leaves_start_date, String leaves_end_date, String leaves_duration, String leaves_reason) {
        this.id = id;
        this.leaves_id = leaves_id;
        this.user_role_id = user_role_id;
        this.leave_category_id = leave_category_id;
        this.leave_status_id = leave_status_id;
        this.leaves_start_date = leaves_start_date;
        this.leaves_end_date = leaves_end_date;
        this.leaves_duration = leaves_duration;
        this.leaves_reason = leaves_reason;
    }

    public Leaves(String leavesStartDate, String leavesEndDate, String leavesDuration, String leavesReason) {
        this.leaves_start_date = leaves_start_date;
        this.leaves_end_date = leaves_end_date;
        this.leaves_duration = leaves_duration;
        this.leaves_reason = leaves_reason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeaves_id() {
        return leaves_id;
    }

    public void setLeaves_id(String leaves_id) {
        this.leaves_id = leaves_id;
    }

    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

    public int getLeave_category_id() {
        return leave_category_id;
    }

    public void setLeave_category_id(int leave_category_id) {
        this.leave_category_id = leave_category_id;
    }

    public int getLeave_status_id() {
        return leave_status_id;
    }

    public void setLeave_status_id(int leave_status_id) {
        this.leave_status_id = leave_status_id;
    }

    public String getLeaves_start_date() {
        return leaves_start_date;
    }

    public void setLeaves_start_date(String leaves_start_date) {
        this.leaves_start_date = leaves_start_date;
    }

    public String getLeaves_end_date() {
        return leaves_end_date;
    }

    public void setLeaves_end_date(String leaves_end_date) {
        this.leaves_end_date = leaves_end_date;
    }

    public String getLeaves_duration() {
        return leaves_duration;
    }

    public void setLeaves_duration(String leaves_duration) {
        this.leaves_duration = leaves_duration;
    }

    public String getLeaves_reason() {
        return leaves_reason;
    }

    public void setLeaves_reason(String leaves_reason) {
        this.leaves_reason = leaves_reason;
    }
}
