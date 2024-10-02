/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.student_management_application;
import java.util.Scanner;

/**
 *
 * @author Khutjo Mamabolo
 */
public class Student_Management_Application {

    public static void main(String[] args) {
        Student_Library library = new Student_Library();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Student Management Application" + "\n"
                + "*********************************************" + "\n"
                + "Please enter (1) to enter menu or any other key to exit");

        int manuSelect = scanner.nextInt();

        while (manuSelect == 1) {
            System.out.println("Please select one of the following menu items: " + "\n"
                    + "(1) Capture a new student" + "\n"
                    + "(2) Search for a Student" + "\n"
                    + "(3) Delete a student" + "\n"
                    + "(4) Print a student report" + "\n"
                    + "(5) Exit Application");

            int Choice = scanner.nextInt();

            switch (Choice) {
                case 1:
                    library.addStudent();
                    break;
                case 2:
                    library.searchStudent();
                    break;
                case 3:
                    library.deleteStudent();
                    break;
                case 4:
                    library.showReport();
                    break;
                case 5:
                    library.exit();
                    break;
            }
        }
    }
}
