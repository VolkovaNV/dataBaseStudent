package com.example.WebServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Student addStudent(Student student) {
        String sql = "INSERT INTO \"Student\" (first_name, second_name, id_speciality, course, num_group) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, student.getFirstName(), student.getSecondName(), student.getSpecialityNumber(), student.getCourse(), student.getGroupNumber());
        return student;
    }
}
