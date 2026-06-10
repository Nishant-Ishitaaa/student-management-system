package com.example.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getStudentInfo() {
        return "This is student information.";
    }
    public String getStudentCount() {
        String sql = "SELECT COUNT(*) FROM students";
        return jdbcTemplate.queryForObject(sql, String.class);
    }
}
