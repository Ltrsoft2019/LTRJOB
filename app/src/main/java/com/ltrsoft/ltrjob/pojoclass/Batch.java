package com.ltrsoft.ltrjob.pojoclass;

public class Batch {
    private int id;
    private String user_id,batch_id,batch_name,batch_time,batch_start_date,batch_end_date,one_time_fees,fees_with_installmaent;

    public Batch( String batch_id, String user_id, String batch_name, String batch_time, String batch_start_date, String batch_end_date, String one_time_fees, String fees_with_installmaent) {
        this.batch_id = batch_id;
        this.user_id = user_id;
        this.batch_name = batch_name;
        this.batch_time = batch_time;
        this.batch_start_date = batch_start_date;
        this.batch_end_date = batch_end_date;
        this.one_time_fees = one_time_fees;
        this.fees_with_installmaent = fees_with_installmaent;
    }

    public Batch(String batchName, String batchTime, String batchStartDate, String batchEndDate, String oneTimeFees, String feesWithInstallmaent) {
        this.batch_name = batchName;
        this.batch_time = batchTime;
        this.batch_start_date = batchStartDate;
        this.batch_end_date = batchEndDate;
        this.one_time_fees = oneTimeFees;
        this.fees_with_installmaent = feesWithInstallmaent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    public String getBatch_name() {
        return batch_name;
    }

    public void setBatch_name(String batch_name) {
        this.batch_name = batch_name;
    }

    public String getBatch_time() {
        return batch_time;
    }

    public void setBatch_time(String batch_time) {
        this.batch_time = batch_time;
    }

    public String getBatch_start_date() {
        return batch_start_date;
    }

    public void setBatch_start_date(String batch_start_date) {
        this.batch_start_date = batch_start_date;
    }

    public String getBatch_end_date() {
        return batch_end_date;
    }

    public void setBatch_end_date(String batch_end_date) {
        this.batch_end_date = batch_end_date;
    }

    public String getOne_time_fees() {
        return one_time_fees;
    }

    public void setOne_time_fees(String one_time_fees) {
        this.one_time_fees = one_time_fees;
    }

    public String getFees_with_installmaent() {
        return fees_with_installmaent;
    }

    public void setFees_with_installmaent(String fees_with_installmaent) {
        this.fees_with_installmaent = fees_with_installmaent;
    }
}
