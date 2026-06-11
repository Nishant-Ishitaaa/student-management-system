package com.example.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.lms.repository.StudentRepository;
import com.example.lms.model.Student;
import java.util.List;

import com.example.lms.dto.StudentRequestDTO;
import com.example.lms.exception.StudentNotFoundException;
import com.example.lms.repository.StudentRepository;


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
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id)
        .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    public Student addStudent(StudentRequestDTO dto) {

    Student student = new Student();
    //converting request dto to entity
    student.setName(dto.getName());
    student.setCourse(dto.getCourse());

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