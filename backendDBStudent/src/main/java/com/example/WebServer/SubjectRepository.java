package com.example.WebServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SubjectRepository (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public String addSubject(String subject) {
        String sql = "INSERT INTO \"Subject\" (name_subject) VALUES (?)";
        jdbcTemplate.update(sql, subject);
        return subject;
    }

}
