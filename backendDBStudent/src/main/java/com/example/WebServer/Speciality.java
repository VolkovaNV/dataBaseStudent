package com.example.WebServer;

import netscape.javascript.JSObject;
public class Speciality {
    private int check;
    private String name_speciality;

    public Speciality() {
        // Пустой конструктор нужен для разбора JSON-данных
    }
    public Speciality(String name_speciality){
        this.name_speciality = name_speciality;
    }

    // Геттеры для доступа к полям

    public String getSpeciality() {
        return name_speciality;
    }

    public void setSpeciality(String name_speciality){
        this.name_speciality = name_speciality;
    }
}
