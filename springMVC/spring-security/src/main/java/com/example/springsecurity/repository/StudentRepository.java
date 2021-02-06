package com.example.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecurity.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
