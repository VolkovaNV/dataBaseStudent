package com.example.WebServer;

import netscape.javascript.JSObject;

public class Student {
    private String lastName;
    private String firstName;
    private int specialityNumber;
    private int course;
    private String groupNumber;

    public Student(String lastName, String firstName, int specialityNumber, int course, String groupNumber) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.specialityNumber = specialityNumber;
        this.course = course;
        this.groupNumber = groupNumber;
    }

    // Геттеры для доступа к полям

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getSpecialityNumber() {
        return specialityNumber;
    }

    public int getCourse() {
        return course;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    // Сеттеры для установки значений полей

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSpecialityNumber(int specialityNumber) {
        this.specialityNumber = specialityNumber;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }
}

