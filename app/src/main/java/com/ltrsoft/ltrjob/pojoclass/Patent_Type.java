package com.ltrsoft.ltrjob.pojoclass;

public class Patent_Type {
    private int patent_type_id;
    private String patent_type_name;

    public Patent_Type(int patent_type_id, String patent_type_name) {
        this.patent_type_id = patent_type_id;
        this.patent_type_name = patent_type_name;
    }

    public int getPatent_type_id() {
        return patent_type_id;
    }

    public void setPatent_type_id(int patent_type_id) {
        this.patent_type_id = patent_type_id;
    }

    public String getPatent_type_name() {
        return patent_type_name;
    }

    public void setPatent_type_name(String patent_type_name) {
        this.patent_type_name = patent_type_name;
    }
}
