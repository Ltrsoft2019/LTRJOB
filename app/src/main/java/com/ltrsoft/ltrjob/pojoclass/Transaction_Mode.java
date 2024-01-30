package com.ltrsoft.ltrjob.pojoclass;

public class Transaction_Mode {

    private int transaction_mode_id;
    private String transaction_mode_name;

    public Transaction_Mode(String transaction_mode_name) {
        this.transaction_mode_id = transaction_mode_id;
        this.transaction_mode_name = transaction_mode_name;
    }

    public int getTransaction_mode_id() {
        return transaction_mode_id;
    }

    public void setTransaction_mode_id(int transaction_mode_id) {
        this.transaction_mode_id = transaction_mode_id;
    }

    public String getTransaction_mode_name() {
        return transaction_mode_name;
    }

    public void setTransaction_mode_name(String transaction_mode_name) {
        this.transaction_mode_name = transaction_mode_name;
    }
}
