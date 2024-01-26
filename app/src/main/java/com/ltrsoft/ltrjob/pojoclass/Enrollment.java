package com.ltrsoft.ltrjob.pojoclass;

public class Enrollment {
    private int id,enrollment_id,user_id,batch_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnrollment_id() {
        return enrollment_id;
    }

    public void setEnrollment_id(int enrollment_id) {
        this.enrollment_id = enrollment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    public Enrollment(int id, int enrollment_id, int user_id, int batch_id) {
        this.id = id;
        this.enrollment_id = enrollment_id;
        this.user_id = user_id;
        this.batch_id = batch_id;
    }
}
