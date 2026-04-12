package com.klu.service;

import com.klu.model.Student;
import com.klu.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
 
@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}