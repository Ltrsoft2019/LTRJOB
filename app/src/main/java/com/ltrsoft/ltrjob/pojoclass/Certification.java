package com.ltrsoft.ltrjob.pojoclass;

public class Certification {

    private String createdat,certification_title,certification_year,certification_from,certification_number;

    public Certification(String certificationId,  String certification_title, String certification_year, String certification_from, String certification_number) {
        this.createdat = certificationId;

        this.certification_title = certification_title;
        this.certification_year = certification_year;
        this.certification_from = certification_from;
        this.certification_number = certification_number;
    }

    public Certification(String imageurl) {
    }

    public String getCreatedat() {
        return createdat;
    }

    public void setCreatedat(String createdat) {
        this.createdat = createdat;
    }

    public String getCertification_title() {
        return certification_title;
    }

    public void setCertification_title(String certification_title) {
        this.certification_title = certification_title;
    }

    public String getCertification_year() {
        return certification_year;
    }

    public void setCertification_year(String certification_year) {
        this.certification_year = certification_year;
    }

    public String getCertification_from() {
        return certification_from;
    }

    public void setCertification_from(String certification_from) {
        this.certification_from = certification_from;
    }

    public String getCertification_number() {
        return certification_number;
    }

    public void setCertification_number(String certification_number) {
        this.certification_number = certification_number;
    }
}
