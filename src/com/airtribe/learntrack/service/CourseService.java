package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

/**
 * Service class to handle business logic related to Courses.
 */


public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }

    public void addCourse(Course course){
        if(course.getCourseName()==null || course.getCourseName().isEmpty()){
            throw new InvalidInputException("Course name cannot be empty");
        }
        if(course.getDurationInWeeks()<=0){
            throw new InvalidInputException("Duration must be greater than zero");
        }
        courseRepository.addCourse(course);
    }

    public void addCourse(String name, String description, int durationInWeeks) {

        if (name == null || name.isBlank()) {
            throw new InvalidInputException("Course name cannot be empty");
        }
        if (durationInWeeks <= 0) {
            throw new InvalidInputException("Duration must be greater than zero");
        }

        Long id = IdGenerator.generateCourseId();

        Course course = new Course(id, name, description, durationInWeeks);

        courseRepository.addCourse(course);
    }


    public List<Course> getAllCourses(){
        return courseRepository.getAllCourses();
    }

    public Course getCourseById(Long id){
        Course course=courseRepository.findById(id);
        if(course==null){
            throw new EntityNotFoundException("Course with ID "+id+" not found");
        }
        return course;
    }

    public void deactivateCourse(Long id){
        Course course=getCourseById(id);
        course.setActive(false);
    }

    public void toggleCourseStatus(Long id) {

        Course course = getCourseById(id);

        course.setActive(!course.getIsActive());
    }



}