package com.ltrsoft.ltrjob.pojoclass;

public class Transaction_Type {

    private int transaction_type_id;
    private String transaction_type_name;

    public Transaction_Type(int transaction_type_id, String transaction_type_name) {
        this.transaction_type_id = transaction_type_id;
        this.transaction_type_name = transaction_type_name;
    }

    public int getTransaction_type_id() {
        return transaction_type_id;
    }

    public void setTransaction_type_id(int transaction_type_id) {
        this.transaction_type_id = transaction_type_id;
    }

    public String getTransaction_type_name() {
        return transaction_type_name;
    }

    public void setTransaction_type_name(String transaction_type_name) {
        this.transaction_type_name = transaction_type_name;
    }
}
