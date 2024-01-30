package com.ltrsoft.ltrjob.pojoclass;

public class Account_Detail {

    private  int account_id;

    private String account_number,bank_name,ifsc_code,user_id;

    public Account_Detail(int account_id, String user_id, String account_number, String bank_name, String ifsc_code) {
        this.account_id = account_id;
        this.user_id = user_id;
        this.account_number = account_number;
        this.bank_name = bank_name;
        this.ifsc_code = ifsc_code;
    }

    public Account_Detail(String accountNumber, String bankName, String ifscCode) {
        this.account_number = account_number;
        this.bank_name = bank_name;
        this.ifsc_code = ifsc_code;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getIfsc_code() {
        return ifsc_code;
    }

    public void setIfsc_code(String ifsc_code) {
        this.ifsc_code = ifsc_code;
    }
}
