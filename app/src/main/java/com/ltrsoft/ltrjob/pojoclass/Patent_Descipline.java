package com.ltrsoft.ltrjob.pojoclass;

public class Patent_Descipline {
    private int patent_descipline_id;
    private String patent_descipline_name;

    public Patent_Descipline(int patent_descipline_id, String patent_descipline_name) {
        this.patent_descipline_id = patent_descipline_id;
        this.patent_descipline_name = patent_descipline_name;
    }

    public int getPatent_descipline_id() {
        return patent_descipline_id;
    }

    public void setPatent_descipline_id(int patent_descipline_id) {
        this.patent_descipline_id = patent_descipline_id;
    }

    public String getPatent_descipline_name() {
        return patent_descipline_name;
    }

    public void setPatent_descipline_name(String patent_descipline_name) {
        this.patent_descipline_name = patent_descipline_name;
    }
}
