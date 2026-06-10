package com.example.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.lms.repository.StudentRepository;
import com.example.lms.model.Student;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

     public Integer getStudentCount() {
        String sql = "SELECT COUNT(*) FROM students";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Autowired
    private StudentRepository studentRepository;

    public String getStudentInfo() {
        return "This is student information.";
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student saveStudent( Student student) {
    return studentRepository.save(student);
}
   
}

// package com.example.lms.service;

// import org.springframework.stereotype.Service;

// @Service
// public class StudentService {

//     public String getMessage() {

//         return "Student Service Working";

//     }

// }