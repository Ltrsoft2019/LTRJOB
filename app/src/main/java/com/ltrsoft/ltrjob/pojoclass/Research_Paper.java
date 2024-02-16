package com.ltrsoft.ltrjob.pojoclass;

public class Research_Paper {

    private int research_paper_id,user_id,research_discipline_id,research_category_id,id;
    private String research_topic_name,research_citation,research_author_1,research_author_2,research_author_3,research_author_4,research_author_5,research_author_6,Published_in,ISBN_no,Location,Pages_start,Pages_end,volumeedition,DOI,date,research_paper_published_in_journal;

    public Research_Paper(int research_paper_id, int user_id, int research_discipline_id, int research_category_id, int id, String research_topic_name, String research_citation, String research_author_1, String research_author_2, String research_author_3, String research_author_4, String research_author_5, String research_author_6, String published_in, String ISBN_no, String location, String pages_start, String pages_end, String volumeedition, String DOI, String date, String research_paper_published_in_journal) {
        this.research_paper_id = research_paper_id;
        this.user_id = user_id;
        this.research_discipline_id = research_discipline_id;
        this.research_category_id = research_category_id;
        this.id = id;
        this.research_topic_name = research_topic_name;
        this.research_citation = research_citation;
        this.research_author_1 = research_author_1;
        this.research_author_2 = research_author_2;
        this.research_author_3 = research_author_3;
        this.research_author_4 = research_author_4;
        this.research_author_5 = research_author_5;
        this.research_author_6 = research_author_6;
        Published_in = published_in;
        this.ISBN_no = ISBN_no;
        Location = location;
        Pages_start = pages_start;
        Pages_end = pages_end;
        this.volumeedition = volumeedition;
        this.DOI = DOI;
        this.date = date;
        this.research_paper_published_in_journal = research_paper_published_in_journal;
    }

    public Research_Paper(String researchTopicName, String researchDisciplineId, String researchCitation, String researchAuthor1, String researchAuthor2, String sresearchAuthor3, String researchAuthor4, String researchAuthor5, String researchAuthor6, String publishedIn, String isbnNo, String location, String pagesStart, String pagesEnd, String volumeedition, String doi, String date, String researchPaperPublishedInJournal) {

         this.research_topic_name=researchTopicName;
        this.research_discipline_id= Integer.parseInt(researchDisciplineId);
        this.research_citation=researchCitation;



    }



    public Research_Paper(String researchTopicName, String researchCitation, String researchAuthor1) {

        this.research_topic_name=researchTopicName;
        this.research_citation=researchCitation;
        this.research_author_1=researchAuthor1;



    }

    public int getResearch_paper_id() {
        return research_paper_id;
    }

    public void setResearch_paper_id(int research_paper_id) {
        this.research_paper_id = research_paper_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getResearch_discipline_id() {
        return research_discipline_id;
    }

    public void setResearch_discipline_id(int research_discipline_id) {
        this.research_discipline_id = research_discipline_id;
    }

    public int getResearch_category_id() {
        return research_category_id;
    }

    public void setResearch_category_id(int research_category_id) {
        this.research_category_id = research_category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResearch_topic_name() {
        return research_topic_name;
    }

    public void setResearch_topic_name(String research_topic_name) {
        this.research_topic_name = research_topic_name;
    }

    public String getResearch_citation() {
        return research_citation;
    }

    public void setResearch_citation(String research_citation) {
        this.research_citation = research_citation;
    }

    public String getResearch_author_1() {
        return research_author_1;
    }

    public void setResearch_author_1(String research_author_1) {
        this.research_author_1 = research_author_1;
    }

    public String getResearch_author_2() {
        return research_author_2;
    }

    public void setResearch_author_2(String research_author_2) {
        this.research_author_2 = research_author_2;
    }

    public String getResearch_author_3() {
        return research_author_3;
    }

    public void setResearch_author_3(String research_author_3) {
        this.research_author_3 = research_author_3;
    }

    public String getResearch_author_4() {
        return research_author_4;
    }

    public void setResearch_author_4(String research_author_4) {
        this.research_author_4 = research_author_4;
    }

    public String getResearch_author_5() {
        return research_author_5;
    }

    public void setResearch_author_5(String research_author_5) {
        this.research_author_5 = research_author_5;
    }

    public String getResearch_author_6() {
        return research_author_6;
    }

    public void setResearch_author_6(String research_author_6) {
        this.research_author_6 = research_author_6;
    }

    public String getPublished_in() {
        return Published_in;
    }

    public void setPublished_in(String published_in) {
        Published_in = published_in;
    }

    public String getISBN_no() {
        return ISBN_no;
    }

    public void setISBN_no(String ISBN_no) {
        this.ISBN_no = ISBN_no;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPages_start() {
        return Pages_start;
    }

    public void setPages_start(String pages_start) {
        Pages_start = pages_start;
    }

    public String getPages_end() {
        return Pages_end;
    }

    public void setPages_end(String pages_end) {
        Pages_end = pages_end;
    }

    public String getVolumeedition() {
        return volumeedition;
    }

    public void setVolumeedition(String volumeedition) {
        this.volumeedition = volumeedition;
    }

    public String getDOI() {
        return DOI;
    }

    public void setDOI(String DOI) {
        this.DOI = DOI;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResearch_paper_published_in_journal() {
        return research_paper_published_in_journal;
    }

    public void setResearch_paper_published_in_journal(String research_paper_published_in_journal) {
        this.research_paper_published_in_journal = research_paper_published_in_journal;
    }
}
