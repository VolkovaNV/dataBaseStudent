package com.example.WebServer;

import netscape.javascript.JSObject;

public class Student {
    private String firstName;
    private String secondName;
    private int id_speciality;
    private int course;
    private String numGroup;

    public Student(String secondName, String firstName, int id_speciality, int course, String numGroup) {

        this.firstName = firstName;
        this.secondName = secondName;
        this.id_speciality = id_speciality;
        this.course = course;
        this.numGroup = numGroup;
    }

    // Геттеры для доступа к полям

    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getSpecialityNumber() {
        return id_speciality;
    }

    public int getCourse() {
        return course;
    }

    public String getGroupNumber() {
        return numGroup;
    }

    // Сеттеры для установки значений полей

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSpecialityNumber(int specialityNumber) {
        this.id_speciality = specialityNumber;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setGroupNumber(String groupNumber) {
        this.numGroup = numGroup;
    }
}

