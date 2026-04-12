package com.klu.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klu.Model.Student;
import com.klu.Repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student updateStudent(Long id, Student student) {
        Student s = repo.findById(id).orElseThrow();
        s.setName(student.getName());
        s.setEmail(student.getEmail());
        s.setCourse(student.getCourse());
        return repo.save(s);
    }
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}