package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(String firstName, String lastName, String email, String batch) {
        Long id = IdGenerator.generateStudentId();
        Student student = new Student(id, firstName, lastName, email, batch);
        studentRepository.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student findStudentById(Long id) {
        Student student = studentRepository.findById(id);
        if (student == null) {
            throw new EntityNotFoundException("Student with ID " + id + " not found.");
        }
        return student;
    }

    public void deactivateStudent(Long id) {
        Student student = findStudentById(id);
        student.setActive(false);
    }

}
