package com.ltrsoft.ltrjob.pojoclass;

public class Financial_transaction {
    private int id,financial_transaction_id,transaction_mode_id,transaction_type_id,status_id,user_id,account_id,institute_id;
    private String financial_transaction_name,amount,remark;

    public Financial_transaction(int id, int financial_transaction_id, int transaction_mode_id, int transaction_type_id, int status_id, int user_id, int account_id, int institute_id, String financial_transaction_name, String amount, String remark) {
        this.id = id;
        this.financial_transaction_id = financial_transaction_id;
        this.transaction_mode_id = transaction_mode_id;
        this.transaction_type_id = transaction_type_id;
        this.status_id = status_id;
        this.user_id = user_id;
        this.account_id = account_id;
        this.institute_id = institute_id;
        this.financial_transaction_name = financial_transaction_name;
        this.amount = amount;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFinancial_transaction_id() {
        return financial_transaction_id;
    }

    public void setFinancial_transaction_id(int financial_transaction_id) {
        this.financial_transaction_id = financial_transaction_id;
    }

    public int getTransaction_mode_id() {
        return transaction_mode_id;
    }

    public void setTransaction_mode_id(int transaction_mode_id) {
        this.transaction_mode_id = transaction_mode_id;
    }

    public int getTransaction_type_id() {
        return transaction_type_id;
    }

    public void setTransaction_type_id(int transaction_type_id) {
        this.transaction_type_id = transaction_type_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getInstitute_id() {
        return institute_id;
    }

    public void setInstitute_id(int institute_id) {
        this.institute_id = institute_id;
    }

    public String getFinancial_transaction_name() {
        return financial_transaction_name;
    }

    public void setFinancial_transaction_name(String financial_transaction_name) {
        this.financial_transaction_name = financial_transaction_name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
