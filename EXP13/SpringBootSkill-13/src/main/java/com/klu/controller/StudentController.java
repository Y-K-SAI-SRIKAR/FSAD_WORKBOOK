package com.klu.controller;

import com.klu.model.Student;
import com.klu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
        return service.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }
}