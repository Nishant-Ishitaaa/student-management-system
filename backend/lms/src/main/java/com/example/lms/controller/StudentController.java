package com.example.lms.controller;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.lms.model.Student;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    @GetMapping
    public ArrayList<Student> getStudents(){
      ArrayList<Student> students = new ArrayList<>();

       students.add(
            new Student(1, "John Doe", "Computer Science")
        );

       students.add(
        new Student(2, "Jane Smith", "Mathematics")
    ) ; 

       return students;
    }
}
