/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.student_management_application;

import java.util.Scanner;

/**
 *
 * @author Khutjo Mamabolo
 */
public class Student_Library {

    private Student[] students = new Student[10];
    private int index = 0;
    Scanner scanner = new Scanner(System.in);

    public Student[] getStudents() {
        return students;
    }

    public int getIndex() {
        return index;
    }
    private boolean isValidAge(int age) {
        return age >= 16;
    }

    public void addStudent(String name, String ID, String email, int age, String course) {
        if (isValidAge(age)) {
            students[index++] = new Student(name, ID, course, email, age);
        } else {
            System.out.println("You have entered an incorrect Student age!!!");
        }
    }


    public void addStudent() {
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("----------------------------");

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student ID: ");
        String ID = scanner.nextLine();

        System.out.print("Enter Student Email: ");
        String Email = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int Age = scanner.nextInt();

        // Checking if the student's age is larger or equal to 16
        while (!isValidAge(Age)) {
            System.out.println("You have entered an incorrect Student age!!!");
            System.out.print("Please re-enter a valid student age: ");
            Age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        }

        System.out.print("Enter Student Course: ");
        String course = scanner.nextLine();

       addStudent(name, ID, Email, Age, course); 
    }

    public void searchStudent(String ID) {
        System.out.println("Enter the Student ID to search: " + ID);
        System.out.println("----------------------------");

        boolean found = false;
        for (int i = 0; i < index; i++) {
            if (students[i].getID().equalsIgnoreCase(ID)) {
                students[i].displayInfor();
                found = true; // Student found
                break;
            }
        }

        if (!found) {
            System.out.println("Student with Student ID: " + ID + " was not found!");
            System.out.println("----------------------------");
        }
    }

    public void searchStudent() {
        System.out.print("Enter the Student ID to search: ");
        String ID = scanner.nextLine();
        System.out.println("----------------------------");

        // Boolean statement used to check if the student was found or not
        boolean found = false;
        for (int i = 0; i < index; i++) {
            if (students[i].getID().equalsIgnoreCase(ID)) {
                students[i].displayInfor();
                found = true; // Student found
                break;
            }
        }

        // If the student is not found
        if (!found) {
            System.out.println("Student with Student ID: " + ID + " was not found!");
            System.out.println("----------------------------");
        }
    }
    
    public void deleteStudent(String ID, boolean confirmDeletion) {
    System.out.println("Enter the Student ID to delete: " + ID);
    System.out.println("----------------------------");

    boolean found = false;
    for (int i = 0; i < index; i++) {
        if (students[i].getID().equalsIgnoreCase(ID)) {
            found = true; // Student found

            if (confirmDeletion) {
                // Shift all the elements to the left to fill in the gap
                for (int j = i; j < index - 1; j++) {
                    students[j] = students[j + 1];
                }

                // Decrement the index because 1 student has been removed
                index--;
                students[index] = null;

                System.out.println("Student with ID: " + ID + " has been successfully deleted.");
                System.out.println("----------------------------");
            } else {
                System.out.println("Deletion cancelled.");
                System.out.println("----------------------------");
            }
            break;
        }
    }

    if (!found) {
        System.out.println("Student with ID: " + ID + " was not found!");
        System.out.println("----------------------------");
    }
}


    public void deleteStudent() {
        System.out.print("Enter the Student ID to delete: ");
        String ID = scanner.nextLine();
        System.out.println("----------------------------");

        // Boolean statement used to check if the student was found or not
        boolean found = false;
        for (int i = 0; i < index; i++) {
            if (students[i].getID().equalsIgnoreCase(ID)) {
                System.out.println("Are you sure you want to delete student " + ID + " from the system? Yes (y) to delete.");
                String choice = scanner.nextLine();
                found = true; // Student found

                if (choice.equalsIgnoreCase("y")) {
                    // Shifting all the elements to the left to fill in the gap
                    for (int j = i; j < index - 1; j++) {
                        students[j] = students[j + 1];
                    }

                    // Decrementing the index because 1 student has been removed
                    index--;
                    students[index] = null;

                    System.out.println("Student with ID: " + ID + " has been successfully deleted.");
                    System.out.println("----------------------------");
                    break;
                } else {
                    System.out.println("Deletion cancelled.");
                    System.out.println("----------------------------");
                    break;
                }
            }
        }

        // If the student is not found
        if (!found) {
            System.out.println("Student with ID: " + ID + " was not found!");
            System.out.println("----------------------------");
        }
    }

    public void showReport() {
        System.out.println("STUDENT REPORT");
        System.out.println("----------------------------");

        if (index == 0) {
            System.out.println("No students available to display.");
        } else {
            for (int i = 0; i < index; i++) {
                students[i].displayInfor();
                System.out.println("----------------------------");
            }
        }
    }

    public void exit() {
        System.out.println("Are you sure you want to exit? Yes (y) to confirm.");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Exiting the program...");
            System.out.println("----------------------------");
            System.exit(0); //exiting the program
        } else {
            System.out.println("Exit canceled.");
            System.out.println("----------------------------");
        }
    }
}
