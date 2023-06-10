package com.example.WebServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpecialityRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SpecialityRepository (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public String addSpeciality(String speciality) {
        String sql = "INSERT INTO \"Speciality\" (name_speciality) VALUES (?)";
        jdbcTemplate.update(sql, speciality);
        return speciality;
    }
}
