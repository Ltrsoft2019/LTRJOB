package com.ltrsoft.ltrjob.pojoclass;

public class Reference_Books {
    private int reference_book_id,id;
    private String reference_book_title,reference_book_author;

    public Reference_Books(int reference_book_id, int id, String reference_book_title, String reference_book_author) {
        this.reference_book_id = reference_book_id;
        this.id = id;


    }

    public Reference_Books(String referenceBookTitle, String referenceBookAuthor) {
        this.reference_book_title = reference_book_title;
        this.reference_book_author = reference_book_author;

    }

    public int getReference_book_id() {
        return reference_book_id;
    }

    public void setReference_book_id(int reference_book_id) {
        this.reference_book_id = reference_book_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference_book_title() {
        return reference_book_title;
    }

    public void setReference_book_title(String reference_book_title) {
        this.reference_book_title = reference_book_title;
    }

    public String getReference_book_author() {
        return reference_book_author;
    }

    public void setReference_book_author(String reference_book_author) {
        this.reference_book_author = reference_book_author;
    }
}
