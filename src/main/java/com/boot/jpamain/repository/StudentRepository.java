package com.boot.jpamain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.jpamain.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
