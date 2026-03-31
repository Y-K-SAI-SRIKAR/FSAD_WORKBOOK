package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.model.student;

public interface StudentRepository extends JpaRepository<student, Integer> {

}
