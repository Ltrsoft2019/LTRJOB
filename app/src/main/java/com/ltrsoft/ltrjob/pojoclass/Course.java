package com.ltrsoft.ltrjob.pojoclass;

public class Course {
    private String id, courseId, courseName, courseDuration, courseDescription;

    public Course(String courseId, String courseName, String courseDuration, String courseDescription) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.courseDescription = courseDescription;
    }

    public Course(String courseId, String courseName, String courseDuration, Object courseDescription, Object o, Object o1, Object o2) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }
}

