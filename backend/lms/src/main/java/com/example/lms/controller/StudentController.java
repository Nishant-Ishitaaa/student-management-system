package com.example.lms.controller;

import com.example.lms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import com.example.lms.model.Student;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.lms.dto.StudentRequestDTO;
import com.example.lms.dto.StudentResponseDTO;
// import com.example.lms.exception.StudentNotFoundException;
// import com.example.lms.repository.StudentRepository;
import java.util.Map;


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

//     @PostMapping
// public Student addStudent(@RequestBody Student student) {
//     return studentService.saveStudent(student);
// }

@PostMapping
public ResponseEntity<?> addStudent(@RequestBody StudentRequestDTO dto) {

    Student student = studentService.addStudent(dto);

    return ResponseEntity.ok(student);
}

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable ("id") Integer id) {
        Student student = studentService.getStudentById(id);
        StudentResponseDTO responseDTO = new StudentResponseDTO(
            student.getId(), 
            student.getName(), 
            student.getCourse()
        );

        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable ("id") Integer id, @RequestBody StudentRequestDTO dto) {
        Student updatedStudent = studentService.updateStudent(id, dto);
        StudentResponseDTO responseDTO = new StudentResponseDTO(
            updatedStudent.getId(),
            updatedStudent.getName(),
            updatedStudent.getCourse()
        );
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable ("id") Integer id) {
        String message = studentService.deleteStudent(id);
        return ResponseEntity.ok(Map.of("message", message));
    }       
    
}
