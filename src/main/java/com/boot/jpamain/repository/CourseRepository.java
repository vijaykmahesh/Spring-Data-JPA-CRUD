package com.boot.jpamain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.jpamain.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	public  List<Course> findByStudentStudentId(Integer studentId);

}
