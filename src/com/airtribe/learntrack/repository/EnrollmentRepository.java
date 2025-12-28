package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;

import java.util.List;
import java.util.ArrayList;

/**
 * Repository class to store and retrieve Enrollment data.
 */

public class EnrollmentRepository {
    // ==In-memory storage ==============
    private final List<Enrollment> enrollments=new ArrayList<>();

    // ========== Operation Methods ===========
    public void addEnrollment(Enrollment enrollment){
        enrollments.add(enrollment);
    }

    public List<Enrollment> getALlEnrollments(){
        return enrollments;
    }

    public Enrollment findById(Long id){
        for (Enrollment enrollment: enrollments){
            if(enrollment.getId().equals(id)){
                return enrollment;
            }
        }
        return null; // handled in service layer
    }

    public List<Enrollment> findByStudentId(Long studentId){
        List<Enrollment> result=new ArrayList<>();
        for (Enrollment enrollment: enrollments){
            if(enrollment.getStudentId().equals(studentId)){
                result.add(enrollment);
            }
        }
        return result;
    }
}