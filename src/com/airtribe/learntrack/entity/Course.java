package com.airtribe.learntrack.entity;
import com.airtribe.learntrack.enums.CourseStatus;

/**
 * Course entity representing a course.
 * Demonstrates basic class structure with constructors,
 * getters, and setters.
 */

public class Course{
    private Long id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private CourseStatus status;

    // ========== Constructors ==========
    public Course(){
        this.status=CourseStatus.ACTIVE;
    }

    public Course(Long id, String courseName, String description, int durationInWeeks, String active){
        this.id=id;
        this.courseName=courseName;
        this.description=description;
        this.durationInWeeks=durationInWeeks;
        this.status=CourseStatus.ACTIVE;
    }

    public Course(Long id, String courseName, String description, int durationInWeeks) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.status = CourseStatus.ACTIVE; // default
    }


    // ========== Getters & Setters ==========
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(String courseName){
        this.courseName=courseName;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public int getDurationInWeeks(){
        return durationInWeeks;
    }

    public CourseStatus getIsActive(){
        return status;
    }

    public void setActive(CourseStatus status){
        this.status=status;
    }

    @Override
    public String toString() {
        return "Course {" +
                "id=" + getId() +
                ", CourseName='" + getCourseName()  + '\'' +
                ", CourseDescription='" + getDescription() + '\'' +
                ", CourseDurationInWeeks='" + getDurationInWeeks() + '\'' +
                ", active=" + getIsActive() +
                '}';
    }

}