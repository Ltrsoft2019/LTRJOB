package com.ltrsoft.ltrjob.pojoclass;

public class Event_type {
    private int id,event_type_id;
    private String event_type_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEvent_type_id() {
        return event_type_id;
    }

    public void setEvent_type_id(int event_type_id) {
        this.event_type_id = event_type_id;
    }

    public String getEvent_type_name() {
        return event_type_name;
    }

    public void setEvent_type_name(String event_type_name) {
        this.event_type_name = event_type_name;
    }

    public Event_type(int id, int event_type_id, String event_type_name) {
        this.id = id;
        this.event_type_id = event_type_id;
        this.event_type_name = event_type_name;
    }
}
