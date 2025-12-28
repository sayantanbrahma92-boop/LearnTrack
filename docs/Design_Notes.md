# 📘 Design Notes – LearnTrack Project

This document explains the key design decisions made while building the **LearnTrack** application and how they align with clean code principles and **Core Java best practices**.

---

## 1️⃣ Why ArrayList Is Used Instead of Array

In LearnTrack, collections such as **Students**, **Courses**, and **Enrollments** are stored using **ArrayList** instead of arrays.

### Reasons for choosing ArrayList:
- **Dynamic size**  
  Arrays have a fixed size, while `ArrayList` can grow or shrink dynamically as elements are added or removed.
- **Ease of use**  
  `ArrayList` provides built-in methods like `add()`, `remove()`, `get()`, and `size()`, making the code simpler and more readable.
- **Better for in-memory storage**  
  Since this project does not use a database, `ArrayList` is ideal for managing objects in memory.

Example:
```java
private List<Student> students = new ArrayList<>();
```

### 2️⃣ Use of Static Members and Why
Static members are used in the IdGenerator utility class.

Why static was used:

IDs need to be unique across the application

Static variables maintain state across method calls

Static methods can be accessed without creating objects

Example:
```java
public class IdGenerator {
    private static long studentIdCounter = 1000;

    public static Long generateStudentId() {
        return ++studentIdCounter;
    }
}
```
Benefits:

Centralized ID generation

No duplication of ID logic

Clean separation of concerns

### 3️⃣ Layered Architecture Explained

The LearnTrack application follows a layered architecture to separate responsibilities and improve maintainability.

Layers:

Entity Layer
Represents domain objects like Student, Course, and Enrollment.

Repository Layer
Handles in-memory data storage and retrieval using ArrayList.

Service Layer
Contains business logic, validations, and coordination between repositories.

UI Layer (Main class)
Handles user interaction, menus, and input/output.

This structure ensures:

Low coupling

High cohesion

Easy debugging and testing

### 4️⃣ Where Inheritance Is Used and Its Benefits

Inheritance is demonstrated using a base class Person and a derived class Student.
Person → common fields like id, firstName, lastName, email

Student → extends Person and adds batch and active

Example:
```java
public class Student extends Person {
    private String batch;
    private boolean active;
}

```



Benefits of Inheritance:

Code reuse – common fields and methods live in the base class

Logical hierarchy – mirrors real-world relationships

Easier maintenance – changes in the base class propagate automatically

Polymorphism – allows handling students as persons where needed

### 5️⃣ Exception Handling Strategy

Custom exceptions like EntityNotFoundException and InvalidInputException are used to:

Avoid application crashes

Show meaningful error messages to the user

Keep validation and error handling centralized in the service layer

Example:
```java
if (student == null) {
throw new EntityNotFoundException("Student not found");
}
```

This approach keeps the UI clean and the business logic robust.

### 6️⃣ Enum Usage and Its Advantages

Enums are used to represent fixed states in the system.

Example:EnrollmentStatus
```java
public enum EnrollmentStatus {
ACTIVE,
COMPLETED,
CANCELLED
}
```

Advantages:

Type safety – prevents invalid values

Readability – clearly expresses intent

Maintainability – easy to extend with new states

Cleaner comparisons – avoids fragile string comparisons

Similarly, CourseStatus is planned to manage course lifecycle states.

### 📚 Summary

The LearnTrack project demonstrates clean Core Java design by applying:

Object-Oriented Programming principles

Layered architecture

Proper exception handling

Enum-based state management

Utility-driven shared logic

These design choices make the application easy to understand, extend, and maintain, 
and they closely resemble real-world backend system design.