package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Course;
import com.klu.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public Course getCourseById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Course addCourse(Course course) {
        return repo.save(course);
    }

    public Course updateCourse(int id, Course course) {
        Course existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setCourseName(course.getCourseName());
            existing.setDepartment(course.getDepartment());
            existing.setCourseDuration(course.getCourseDuration());
            existing.setFee(course.getFee());
            return repo.save(existing);
        }
        return null;
    }

    public String deleteCourse(int id) {
        repo.deleteById(id);
        return "Course deleted successfully";
    }
}
