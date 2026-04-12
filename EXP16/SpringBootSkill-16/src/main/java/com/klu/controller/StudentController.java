package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.klu.enity.Student;
import com.klu.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
@Tag(name = "Student Controller")
public class StudentController {

    @Autowired
    private StudentService service;

    @Operation(summary = "Add student")
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(service.saveStudent(student));
    }

    @Operation(summary = "Get all students")
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    @Operation(summary = "Get student by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    @Operation(summary = "Update student")
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                 @RequestBody Student student) {
        return ResponseEntity.ok(service.updateStudent(id, student));
    }

    @Operation(summary = "Delete student")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}