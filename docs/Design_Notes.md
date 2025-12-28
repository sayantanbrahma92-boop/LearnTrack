# 📘 Design Notes – LearnTrack Project

This document explains the key design decisions made while building the **LearnTrack** application and how they align with clean code and Core Java best practices.

---

## 1️⃣ Why ArrayList Is Used Instead of Array

In LearnTrack, collections such as Students, Courses, and Enrollments are stored using **ArrayList** instead of arrays.

### Reasons for choosing ArrayList:
- **Dynamic size**:  
  Arrays have a fixed size, while `ArrayList` can grow and shrink dynamically as elements are added or removed.
- **Ease of use**:  
  `ArrayList` provides built-in methods like `add()`, `remove()`, `get()`, and `size()`, making code simpler and more readable.
- **Better for in-memory storage**:  
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

-Centralized ID generation
-No duplication of ID logic
-Clean separation of concerns



### 3️⃣ Layered Architecture Explained
The LearnTrack application follows a clean layered architecture to separate concerns and improve maintainability.

### 4️⃣ Where Inheritance Is Used and Its Benefits
Inheritance is demonstrated using a base class Person and a derived class Student.

Example:

Person → common fields like id, firstName, lastName, email

Student → extends Person and adds batch, active
Example:
```java
public class Student extends Person {
private String batch;
private boolean active;
}
```

Benefits of Inheritance:
- Code reuse: Common fields and methods are defined in the base class.
- Logical hierarchy: Represents real-world relationships.
- Easier maintenance: Changes in the base class propagate to derived classes. 
Polymorphism: Allows treating derived classes as base class types.

- ### 5️⃣ Exception Handling Strategy
Custom exceptions like EntityNotFoundException and InvalidInputException are used to:
Avoid application crashes
Show meaningful messages to the user
Keep error handling centralized   
Example:
```java
    if (student == null) {
        throw new EntityNotFoundException("Student not found");
    }
```

### 6️⃣ Enum Usage and Its Advantages
The EnrollmentStatus enum is used to represent the status of an enrollment.
Example:
```java
public enum EnrollmentStatus {
    ACTIVE, COMPLETED,
    DROPPED
}
```
Advantages:
- Type safety: Only valid statuses can be assigned.         
- Readability: Clear representation of possible values.
- Maintainability: Easy to add new statuses if needed.
- Cleaner comparisons: Use enum constants instead of string literals.

---
## 📚 Summary        
The LearnTrack project demonstrates clean Core Java design using OOP principles, 
proper layering, and best practices.
The design choices ensure the application is easy to understand, extend, and maintain.

