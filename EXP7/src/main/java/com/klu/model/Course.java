package com.klu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="courses")
public class Course {

    @Id
    private int courseId;
    private String courseName;
    private String department;
    private String courseDuration;
    private double fee;

    public Course() {
        super();
    }

    public Course(int courseId, String courseName, String department,
                  String courseDuration, double fee) {
        super();
        this.courseId = courseId;
        this.courseName = courseName;
        this.department = department;
        this.courseDuration = courseDuration;
        this.fee = fee;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Course [courseId=" + courseId +
               ", courseName=" + courseName +
               ", department=" + department +
               ", courseDuration=" + courseDuration +
               ", fee=" + fee + "]";
    }
}
