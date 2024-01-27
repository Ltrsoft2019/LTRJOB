package com.ltrsoft.ltrjob.pojoclass;

public class Research_Discipline {
    private int research_discipline_id;
    private String research_discipline_name;

    public Research_Discipline(int research_discipline_id, String research_discipline_name) {
        this.research_discipline_id = research_discipline_id;
        this.research_discipline_name = research_discipline_name;
    }

    public int getResearch_discipline_id() {
        return research_discipline_id;
    }

    public void setResearch_discipline_id(int research_discipline_id) {
        this.research_discipline_id = research_discipline_id;
    }

    public String getResearch_discipline_name() {
        return research_discipline_name;
    }

    public void setResearch_discipline_name(String research_discipline_name) {
        this.research_discipline_name = research_discipline_name;
    }
}
