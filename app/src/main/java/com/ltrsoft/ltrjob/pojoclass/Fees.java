package com.ltrsoft.ltrjob.pojoclass;

public class Fees {
    private int id,fees_id,enrollment_id;
    private String paid_fees,remaining_fees;

    public Fees(int id, int fees_id, int enrollment_id, String paid_fees, String remaining_fees) {
        this.id = id;
        this.fees_id = fees_id;
        this.enrollment_id = enrollment_id;
        this.paid_fees = paid_fees;
        this.remaining_fees = remaining_fees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFees_id() {
        return fees_id;
    }

    public void setFees_id(int fees_id) {
        this.fees_id = fees_id;
    }

    public int getEnrollment_id() {
        return enrollment_id;
    }

    public void setEnrollment_id(int enrollment_id) {
        this.enrollment_id = enrollment_id;
    }

    public String getPaid_fees() {
        return paid_fees;
    }

    public void setPaid_fees(String paid_fees) {
        this.paid_fees = paid_fees;
    }

    public String getRemaining_fees() {
        return remaining_fees;
    }

    public void setRemaining_fees(String remaining_fees) {
        this.remaining_fees = remaining_fees;
    }
}
