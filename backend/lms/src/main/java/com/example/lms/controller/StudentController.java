package com.example.lms.controller;

import com.example.lms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import com.example.lms.model.Student;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/count")
    public Integer getStudentCount() {
        return studentService.getStudentCount();
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
public Student addStudent(@RequestBody Student student) {
    return studentService.saveStudent(student);
}
}
//      @Autowired
//     JdbcTemplate jdbcTemplate;

//        @GetMapping("/count")
//     public int countStudents() {

//         String sql = "SELECT COUNT(*) FROM students";

//         return jdbcTemplate.queryForObject(
//                 sql,
//                 Integer.class
//         );

       
//     }
// }
// public class StudentController {

//     @Autowired
//     private StudentService studentService;

//     @GetMapping("/message")
//     public String getMessage() {
//         return studentService.getMessage();
//     }
// }