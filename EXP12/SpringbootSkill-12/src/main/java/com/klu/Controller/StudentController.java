package com.klu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.klu.Model.Student;
import com.klu.Service.StudentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(service.saveStudent(student));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                 @RequestBody Student student) {
        return ResponseEntity.ok(service.updateStudent(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}