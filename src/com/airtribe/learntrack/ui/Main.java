package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // -------- Wiring --------
        StudentRepository studentRepository = new StudentRepository();
        CourseRepository courseRepository = new CourseRepository();
        EnrollmentRepository enrollmentRepository = new EnrollmentRepository();

        StudentService studentService = new StudentService(studentRepository);
        CourseService courseService = new CourseService(courseRepository);
        EnrollmentService enrollmentService =
                new EnrollmentService(enrollmentRepository, studentService, courseService);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to LearnTrack");

        // -------- Main Menu --------
        while (true) {
            try {
                System.out.println("\n===== MAIN MENU =====");
                System.out.println("1. Student Management");
                System.out.println("2. Course Management");
                System.out.println("3. Enrollment Management");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        studentMenu(scanner, studentService);
                        break;
                    case 2:
                        courseMenu(scanner, courseService);
                        break;
                    case 3:
                        enrollmentMenu(scanner, enrollmentService);
                        break;
                    case 0:
                        System.out.println("Exiting Now!! Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    // ================= STUDENT MENU =================

    private static void studentMenu(Scanner scanner, StudentService studentService) {

        while (true) {
            try {
                System.out.println("\n--- STUDENT MENU ---");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Find Student by ID");
                System.out.println("4. Deactivate Student");
                System.out.println("0. Back");
                System.out.print("Enter choice: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addStudent(scanner, studentService);
                        break;
                    case 2:
                        viewAllStudents(studentService);
                        break;
                    case 3:
                        findStudentById(scanner, studentService);
                        break;
                    case 4:
                        deactivateStudent(scanner, studentService);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option.");
                }

            } catch (InvalidInputException | EntityNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
    }
    // ================= Course MENU =================

    private static void courseMenu(Scanner scanner, CourseService courseService) {

        while (true) {
            try {
                System.out.println("\n--- Course MENU ---");
                System.out.println("1. Add Course");
                System.out.println("2. View All Course");
                System.out.println("3. Activate or Deactivate ");
                System.out.println("0. Back");
                System.out.print("Enter choice: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addCourse(scanner, courseService);
                        break;
                    case 2:
                        viewAllCourses(courseService);
                        break;
                    case 3:
                        toggleCourseStatus(scanner, courseService);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }


    // ================= Enrollment Menu =================
    private static void enrollmentMenu(Scanner scanner, EnrollmentService enrollmentService) {
        try {
            System.out.println("\n--- Enrollment MENU ---");
            System.out.println("1. Enroll Student in Course");
            System.out.println("2. View Enrollments by Student Id");
            System.out.println("3. Update ENrollment Status");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    enrollStudent(scanner, enrollmentService);
                    break;
                case 2:
                    viewEnrollmentsByStudent(scanner, enrollmentService);
                    break;
                case 3:
                    updateEnrollmentStatus(scanner, enrollmentService);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ================= STUDENT OPERATIONS =================

    private static void addStudent(Scanner scanner, StudentService studentService) {

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Batch: ");
        String batch = scanner.nextLine();

        studentService.addStudent(firstName, lastName, email, batch);

        System.out.println("Student added successfully.");
    }

    private static void viewAllStudents(StudentService studentService) {

        List<Student> students = studentService.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void findStudentById(Scanner scanner, StudentService studentService) {

        System.out.print("Enter Student ID: ");
        Long id = Long.parseLong(scanner.nextLine());

        Student student = studentService.findStudentById(id);
        System.out.println(student);
    }

    private static void deactivateStudent(Scanner scanner, StudentService studentService) {

        System.out.print("Enter Student ID: ");
        Long id = Long.parseLong(scanner.nextLine());

        studentService.deactivateStudent(id);
        System.out.println("Student deactivated successfully.");
    }

    // ================= COURSE OPERATIONS =================
    private static void addCourse(Scanner scanner, CourseService courseService) {
        System.out.println("Course Name: ");
        String name = scanner.nextLine();

        System.out.println("Course Description: ");
        String description = scanner.nextLine();

        System.out.println("Course Duration (in hours): ");
        int duration = Integer.parseInt(scanner.nextLine());

        courseService.addCourse(name, description, duration);
        System.out.println("Course added successfully.");
    }

    private static void viewAllCourses(CourseService courseService) {
        List<Course> courses = courseService.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private static void toggleCourseStatus(Scanner scanner, CourseService courseService) {
        System.out.println("Enter Course Id:");
        Long courseId = Long.parseLong(scanner.nextLine());

        courseService.toggleCourseStatus(courseId);
    }

    // ================= ENROLLMENT OPERATIONS =================
    private static void enrollStudent(Scanner scanner, EnrollmentService enrollmentService){
        System.out.println("Enter Student Id: ");
        Long studentId=Long.parseLong(scanner.nextLine());

        System.out.println("Enter Course Id:");
        Long courseId=Long.parseLong(scanner.nextLine());

        enrollmentService.enrollStudent(studentId, courseId);

        System.out.println("Student enrolled  successfully.");
    }

    private static void viewEnrollmentsByStudent(Scanner scanner, EnrollmentService enrollmentService){
        System.out.print("Enter Student ID: ");
        Long studentId=Long.parseLong(scanner.nextLine());

        List<Enrollment> enrollments=enrollmentService.getEnrollmentsByStudentId(studentId);
        if(enrollments.isEmpty()){
            System.out.println("No enrollments found for the student.");
            return;
        }
        for (Enrollment enrollment: enrollments){
            System.out.println(enrollment);
        }

    }

    private static void updateEnrollmentStatus(Scanner scanner, EnrollmentService enrollmentService){
        System.out.print("Enter Enrollment ID: ");
        Long enrollmentId=Long.parseLong(scanner.nextLine());

        System.out.print("Enter new status (ACTIVE, COMPLETED, CANCELLED): ");
        EnrollmentStatus status =
                EnrollmentStatus.valueOf(scanner.nextLine().toUpperCase());

        enrollmentService.updateEnrollmentStatus(enrollmentId, status);
        System.out.println("Enrollment status updated successfully.");
    }

}



