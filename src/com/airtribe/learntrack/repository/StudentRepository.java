package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;
import java.util.List;
import java.util.ArrayList;


/**
 * Repository class to store and retrieve Student data.
 */

public class StudentRepository  {

    // ========== In-memory storage ==========
    private final List<Student> students=new ArrayList<>();

    // ========== Operation Methods ==========
    public void addStudent(Student student){
        students.add(student);
    }

    public List<Student> getAllStudents(){
        return students;
    }

    public Student findById(Long id){
        for (Student student: students){
            if (student.getId()==id){
                return student;
            }

        }
        return null; // handled in service layer
    }

}