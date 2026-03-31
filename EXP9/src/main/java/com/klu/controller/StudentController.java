package com.klu.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.exceptions.StudentNotFoundException;
import com.klu.model.student;
import com.klu.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // CREATE
    @PostMapping
    public student addStudent(@RequestBody student student) {
        studentService.addStudent(student);
        return student;
    }

    // READ ALL
    @GetMapping
    public List<student> getAllStudents(){
        return studentService.getAllStudents();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public student getById(@PathVariable int id) {
        return studentService.getById(id);
    }

    // UPDATE
    @PutMapping
    ("/{id}")public student updateStudent(@PathVariable int id, @RequestBody student student){
        return studentService.updateStudent(id, student);
    }

    // DELETE
    @DeleteMapping
    ("/{id}")
    public String deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }

    // Optional (if not using GlobalExceptionHandler)
    
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudent(StudentNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
