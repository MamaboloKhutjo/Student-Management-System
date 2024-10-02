/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.student_management_application;

/**
 *
 * @author Khutjo Mamabolo
 */
public class Student {

    private String name, ID, course, email;
    private int age;

    public Student(String names, String id, String courses, String Email, int Age) {
        this.name = names;
        this.ID = id;
        this.age = Age;
        this.course = courses;
        this.email = Email;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }
    
    public int getAge(){
        return age;
    }

    public void displayInfor() {
        System.out.println("name: " + name + "\n"
                + "ID: " + ID + "\n"
                + "Age: " + age + "\n"
                + "Course: " + course + "\n"
                + "email: " + email + "\n"
                + "----------------------------------------");
    }
}
