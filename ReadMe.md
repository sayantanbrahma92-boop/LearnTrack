# 📘 LearnTrack – Student & Course Management System (Core Java)

## 📌 Project Description

**LearnTrack** is a **console-based Student, Course, and Enrollment Management System** built using **Core Java**.  
The application allows an admin to manage:

- 👨‍🎓 Students
- 📚 Courses
- 📝 Enrollments (linking students to courses)

The project is intentionally designed to focus on **Java fundamentals** and follows a **clean layered architecture**:

- **Entity Layer** – Data models such as `Student`, `Course`, and `Enrollment`
- **Service Layer** – Business logic and validations
- **Repository Layer** – In-memory data storage using `ArrayList`
- **UI Layer** – Menu-driven console interface (`Main.java`)

### 🎯 Key Concepts Demonstrated

- Core Java syntax and control flow
- Object-Oriented Programming (OOP)
    - Encapsulation
    - Inheritance
    - Polymorphism
- Constructors and method overloading
- Static utility classes (`IdGenerator`)
- Collections (`ArrayList`)
- Enum usage (`EnrollmentStatus`)
- Custom exception handling
- Clean code and separation of concerns

> ⚠️ Note:  
> This project uses **in-memory storage only** (no database).  
> All data is reset every time the application restarts.

---

## ▶️ How to Compile and Run

### ✅ Prerequisites

- **Java JDK 8 or above**
- IDE (IntelliJ IDEA / Eclipse) **or** Command Line
- Git (optional, for cloning the repository)

---

### ▶️ Run Using an IDE (Recommended)

1. Clone the repository:
   ```bash
   git clone <your-github-repository-url>
   
2. # 📘 LearnTrack – Student & Course Management System (Core Java)

## 📌 Project Description

**LearnTrack** is a **console-based Student, Course, and Enrollment Management System** built using **Core Java**.  
The application allows an admin to manage:

- 👨‍🎓 Students
- 📚 Courses
- 📝 Enrollments (linking students to courses)

The project is intentionally designed to focus on **Java fundamentals** and follows a **clean layered architecture**:

- **Entity Layer** – Data models such as `Student`, `Course`, and `Enrollment`
- **Service Layer** – Business logic and validations
- **Repository Layer** – In-memory data storage using `ArrayList`
- **UI Layer** – Menu-driven console interface (`Main.java`)

### 🎯 Key Concepts Demonstrated

- Core Java syntax and control flow
- Object-Oriented Programming (OOP)
    - Encapsulation
    - Inheritance
    - Polymorphism
- Constructors and method overloading
- Static utility classes (`IdGenerator`)
- Collections (`ArrayList`)
- Enum usage (`EnrollmentStatus`)
- Custom exception handling
- Clean code and separation of concerns

> ⚠️ Note:  
> This project uses **in-memory storage only** (no database).  
> All data is reset every time the application restarts.

---

## ▶️ How to Compile and Run

### ✅ Prerequisites

- **Java JDK 8 or above**
- IDE (IntelliJ IDEA / Eclipse) **or** Command Line
- Git (optional, for cloning the repository)

---

### ▶️ Run Using an IDE (Recommended)

1. Clone the repository:
   ```bash
   git clone <your-github-repository-url>
2. Open your IDE and select "Open Project".
3. Navigate to the cloned repository folder and open it
   ```bash
   src/com/airtribe/learntrack/ui/Main.java
4. Locate the `Main.java` file in the `ui` package.
5. Run the `Main` class by right-clicking and selecting "Run Main.main()".

### ▶️ Compile and Run Using Command Line
1. Navigate to the project root directory:
   ```bash```
   cd LearnTrack
   ```
2. Compile all Java files:
   ```bash
   javac -d out src/com/airtribe/learntrack/**/*.java
   ```
3. Run the application:
   ```bash
   java -cp out com.airtribe.learntrack.ui.Main
   ```
### ✅ Features Available
- Add, view, update, and delete students
- Add, view, and activate/deactivate courses
- Enroll students in courses
- View enrollments by student
- Update enrollment status (ACTIVE / COMPLETED / CANCELLED)

### 📂 Project Structure (High-Level)
    com.airtribe.learntrack
    │
    ├── entity        → Student, Course, Enrollment
    ├── service       → Business logic
    ├── repository    → In-memory data storage
    ├── exception     → Custom exceptions
    ├── util          → ID generator utilities, InputValidatorUtils
    ├── enums         → EnrollmentStatus, CourseStatus
    └── ui            → Console UI (Main.java)

### 🏁 Conclusion
This LearnTrack project serves as a foundational example of building a console-based application using Core Java. It emphasizes clean architecture, OOP principles, and Java fundamentals, making it an excellent starting point for beginners looking to enhance their Java skills.  

                    
