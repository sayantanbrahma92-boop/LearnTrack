package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.List;

/**
 * Service class to handle business logic related to Enrollments.
 */

public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentService(EnrollmentRepository enrollmentRepository,
                             StudentService studentService,
                             CourseService courseService) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    // ======= Enroll a student in a course ========
    public void enrollStudent(Long StudentId, Long courseId) {
        // Validate Student exists
        studentService.findStudentById(StudentId);

        // Validate course exists
        courseService.getCourseById(courseId);

        Enrollment enrollment = new Enrollment(IdGenerator.generateEnrollmentId(),
                StudentId, courseId, LocalDate.now(), EnrollmentStatus.ACTIVE);
        enrollmentRepository.addEnrollment(enrollment);

    }

    // ======= View enrollments for a student ========
    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        // validate Student exists
        studentService.findStudentById(studentId);
        return enrollmentRepository.findByStudentId(studentId);
    }


    // ======== Mark enrollment as completed/cancelled ============
    public void updateEnrollmentStatus(Long enrollmentId, EnrollmentStatus status) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId);
        if (enrollment == null) {
            throw new EntityNotFoundException("Enrollment with ID " + enrollmentId + " not found.");
        }
        enrollment.setStatus(status);
    }
}
