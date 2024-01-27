package com.ltrsoft.ltrjob.pojoclass;

public class Installement {
    private int id,installment_id,fees_id;
    private String installement_amount,installement_date,installement_time;

    public Installement(int id, int installment_id, int fees_id, String installement_amount, String installement_date, String installement_time) {
        this.id = id;
        this.installment_id = installment_id;
        this.fees_id = fees_id;
        this.installement_amount = installement_amount;
        this.installement_date = installement_date;
        this.installement_time = installement_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInstallment_id() {
        return installment_id;
    }

    public void setInstallment_id(int installment_id) {
        this.installment_id = installment_id;
    }

    public int getFees_id() {
        return fees_id;
    }

    public void setFees_id(int fees_id) {
        this.fees_id = fees_id;
    }

    public String getInstallement_amount() {
        return installement_amount;
    }

    public void setInstallement_amount(String installement_amount) {
        this.installement_amount = installement_amount;
    }

    public String getInstallement_date() {
        return installement_date;
    }

    public void setInstallement_date(String installement_date) {
        this.installement_date = installement_date;
    }

    public String getInstallement_time() {
        return installement_time;
    }

    public void setInstallement_time(String installement_time) {
        this.installement_time = installement_time;
    }
}
