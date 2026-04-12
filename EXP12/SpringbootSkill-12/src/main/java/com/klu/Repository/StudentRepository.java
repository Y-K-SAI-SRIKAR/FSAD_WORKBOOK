package com.klu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
