package com.klu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.exceptions.StudentNotFoundException;
import com.klu.model.student;
import com.klu.repository.StudentRepository;

@Service
public class StudentService {
	 private final StudentRepository studentRepo;

	    public StudentService(StudentRepository studentRepo){
	        this.studentRepo = studentRepo;
	    }

	    // Insert Student
	    public String addStudent(student student) {
	        studentRepo.save(student);
	        return "Student inserted successfully";
	    }

	    // Get All Students
	    public List<student> getAllStudents(){
	        return studentRepo.findAll();
	    }

	    // Get Student By ID
	    public student getById(int id) {
	        return studentRepo.findById(id)
	                .orElseThrow(() -> 
	                    new StudentNotFoundException("Student not found with id: " + id));
	    }

	    // Update Student
	    public student updateStudent(int id, student newStudent) {

	        student existing = studentRepo.findById(id)
	                .orElseThrow(() -> 
	                    new StudentNotFoundException("Student not found with id: " + id));

	        existing.setName(newStudent.getName());
	        existing.setAge(newStudent.getAge());

	        return studentRepo.save(existing);
	    }

	    // Delete Student
	    public String deleteStudent(int id) {

	        if(!studentRepo.existsById(id)) {
	            throw new StudentNotFoundException("Student not found with id: " + id);
	        }

	        studentRepo.deleteById(id);
	        return "Student deleted successfully";
	    }

}
