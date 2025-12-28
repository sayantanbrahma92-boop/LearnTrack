package com.airtribe.learntrack.util;

/**
 * Utility class to generate unique IDs
 * using static counters.
 */
public class IdGenerator {

    private static long studentIdCounter = 1000;
    private static long courseIdCounter = 2000;
    private static long enrollmentIdCounter = 3000;

    // Prevent object creation
    private IdGenerator() {}

    public static Long generateStudentId() {
        return ++studentIdCounter;
    }

    public static Long generateCourseId() {
        return ++courseIdCounter;
    }

    public static Long generateEnrollmentId() {
        return ++enrollmentIdCounter;
    }
}
