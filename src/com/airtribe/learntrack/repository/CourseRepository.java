package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import java.util.List;
import java.util.ArrayList;

/**
 * Repository class to store and retrieve Course data.
 */

public class CourseRepository {
    // ========== In-memory storage ==========
    private final List<Course> courses=new ArrayList<>();

    // ========== Operation Methods ==========
    public void addCourse(Course course){
        courses.add(course);
    }

    public List<Course> getAllCourses(){
        return courses;
    }

    public Course findById(Long id){
        for(Course course: courses){
            if(course.getId().equals(id)){
                return course;
            }
        }
        return null; // handled in service layer
    }
}