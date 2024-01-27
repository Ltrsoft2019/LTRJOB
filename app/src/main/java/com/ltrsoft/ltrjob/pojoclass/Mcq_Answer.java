package com.ltrsoft.ltrjob.pojoclass;

public class Mcq_Answer {
    private String mcq_answer_name;
    private int mcq_answer_id,mcq_id;

    public Mcq_Answer(String mcq_answer_name, int mcq_answer_id, int mcq_id) {
        this.mcq_answer_name = mcq_answer_name;
        this.mcq_answer_id = mcq_answer_id;
        this.mcq_id = mcq_id;
    }

    public String getMcq_answer_name() {
        return mcq_answer_name;
    }

    public void setMcq_answer_name(String mcq_answer_name) {
        this.mcq_answer_name = mcq_answer_name;
    }

    public int getMcq_answer_id() {
        return mcq_answer_id;
    }

    public void setMcq_answer_id(int mcq_answer_id) {
        this.mcq_answer_id = mcq_answer_id;
    }

    public int getMcq_id() {
        return mcq_id;
    }

    public void setMcq_id(int mcq_id) {
        this.mcq_id = mcq_id;
    }
}
