/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.student_management_application;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;

/**
 *
 * @author Khutjo Mamabolo
 */
public class Student_LibraryTest {

    private Student_Library library;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        library = new Student_Library();
        library.addStudent("Khutjo Mamabolo", "12345", "khutjo@sentinel.co.za", 21, "DISD0601");
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void TestSaveStudent() {

        // Retrieve the student and check details
        Student[] students = library.getStudents();

        Student addedStudent = students[0];
        assertEquals("Khutjo Mamabolo", addedStudent.getName());
        assertEquals("12345", addedStudent.getID());
        assertEquals("khutjo@sentinel.co.za", addedStudent.getEmail());
        assertEquals(21, addedStudent.getAge());
        assertEquals("DISD0601", addedStudent.getCourse());
    }

    @Test
    public void testSearchStudent() {
        // Call the method with a known ID
        library.searchStudent("12345");

        // Verify output
        String output = outputStream.toString().trim();
        assertTrue(output.contains("name: " + "Khutjo Mamabolo"));
        assertTrue(output.contains("ID: " + "12345"));
        assertTrue(output.contains("Age: " + 21));
        assertTrue(output.contains("Course: " + "DISD0601"));
        assertTrue(output.contains("email: " + "khutjo@sentinel.co.za"));
    }

    @Test
    public void TestSearchStudent_StudentNotFound() {
        // Call the method with an incorrect ID
        library.searchStudent("67890");

        // Verify output
        String output = outputStream.toString().trim();
        assertFalse(output.contains("Student with Student ID was not found!"));
    }

    @Test
    public void TestDeleteStudent() {
        // Directly delete the student by supplying the ID and confirming deletion
        library.deleteStudent("12345", true);

        // Verify that the student has been deleted
        Student[] students = library.getStudents();
        boolean studentFound = false;
        for (Student student : students) {
            if (student != null && student.getID().equals("12345")) {
                studentFound = true;
                break;
            }
        }
        assertFalse(studentFound, "The student should have been deleted.");

        // Verify output
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Student with ID: 12345 has been successfully deleted."));
    }

    @Test
    public void TestDeleteStudent_StudentNotFound() {
        // Redirect System.out to capture the output for testing
        System.setOut(new PrintStream(outputStream));

        // Try to delete a student with a non-existing ID
        library.deleteStudent("99999", false);

        // Verify output
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Student with ID: 99999 was not found!"));

        // Reset System.out
        System.setOut(originalOut);
    }

    @Test
    public void TestStudentAge_StudentAgeValid() {
        // Create a new student with a valid age
        library.addStudent("Paul Barne", "70238", "Oldman1@gmail.com", 30, "DISD0602");

        // Retrieve the student and check if the age is valid
        Student[] students = library.getStudents();
        Student addedStudent = students[1]; // Since it's the second student added

        // Ensure the age is valid
        assertEquals(30, addedStudent.getAge(), "The student's age should be valid.");
    }

    @Test
    public void TestStudentAge_StudentAgeInvalid() {
        // Record the initial count of students
        int initialIndex = library.getIndex();

        // Attempt to add a student with an invalid age (15)
        library.addStudent("Paul Barne", "70238", "Oldman1@gmail.com", 15, "DISD0602");

        // Verify that the count of students has not changed
        assertEquals(initialIndex, library.getIndex(), "The number of students should remain the same for an invalid age.");

        // Verify that no new student was added by checking the array contents
        Student[] students = library.getStudents();
        assertEquals("Khutjo Mamabolo", students[0].getName(), "The existing student should be present.");
        assertNull(students[1], "No new student should have been added to the second position.");
    }
}
