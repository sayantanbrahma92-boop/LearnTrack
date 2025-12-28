# 🚀 LearnTrack Project – Setup Instructions

Follow these steps to set up and run the LearnTrack (Student & Course Management System) project.

---

## 1️⃣ JDK Version Used

This project was developed and tested using **JDK 17** or later. The following is an example of a JDK version check on this system:

```
PS C:\Windows\System32\WindowsPowerShell\v1.0> java --version
java 25.0.1 2025-10-21 LTS
Java(TM) SE Runtime Environment (build 25.0.1+8-LTS-27)
Java HotSpot(TM) 64-Bit Server VM (build 25.0.1+8-LTS-27, mixed mode, sharing)
```

- If your output shows version 17 or higher (as above), you are ready to run LearnTrack.
- Download JDK from the [official Oracle website](https://www.oracle.com/java/technologies/downloads/) or use OpenJDK if you need to upgrade.
- Ensure your `JAVA_HOME` environment variable is set to the JDK installation directory.

---

## 2️⃣ Running a “Hello World” Program (Java)

Before running the LearnTrack project, you can verify your Java setup by running a simple Hello World program:

**HelloWorld.java**
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

**Steps to Run:**
1. Save the above code in a file named `HelloWorld.java`.
2. Open a terminal in the file's directory.
3. Compile the program:
   ```powershell
   javac HelloWorld.java
   ```
4. Run the program:
   ```powershell
   java HelloWorld
   ```
5. You should see the output:
   ```
   Hello, World!
   ```

This confirms your Java environment is set up correctly.

---

## 3️⃣ Running the LearnTrack Project

1. **Clone or Download the Project:**
   - Place the project folder on your computer.

2. **Navigate to the Source Directory:**
   - Open a terminal and change directory to:
     ```powershell
     cd path\to\LearnTrack\src
     ```

3. **Compile the Project:**
   - Compile all Java files:
     ```powershell
     javac com/airtribe/learntrack/ui/Main.java
     ```

4. **Run the Application:**
   - Start the main program:
     ```powershell
     java com.airtribe.learntrack.ui.Main
     ```

5. **Follow On-Screen Instructions:**
   - The console UI will guide you through managing students, courses, and enrollments.

---

## 4️⃣ Troubleshooting

- Ensure you are using JDK 17 or later.
- If you see classpath errors, make sure you are in the correct directory and using the correct package structure.
- For any issues, check your Java installation and environment variables.

---

**Enjoy using LearnTrack!**
