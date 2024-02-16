package com.ltrsoft.ltrjob.pojoclass;

public class Award {

    String name, reciveddate, awardvanue, awardcategeryname;

    public Award(String name, String reciveddate, String awardvanue, String awardcategeryname) {
        this.name = name;
        this.reciveddate = reciveddate;
        this.awardvanue = awardvanue;
        this.awardcategeryname = awardcategeryname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReciveddate() {
        return reciveddate;
    }

    public void setReciveddate(String reciveddate) {
        this.reciveddate = reciveddate;
    }

    public String getAwardvanue() {
        return awardvanue;
    }

    public void setAwardvanue(String awardvanue) {
        this.awardvanue = awardvanue;
    }

    public String getAwardcategeryname() {
        return awardcategeryname;
    }

    public void setAwardcategeryname(String awardcategeryname) {
        this.awardcategeryname = awardcategeryname;
    }
}
