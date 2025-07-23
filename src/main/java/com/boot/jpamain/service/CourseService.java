package com.boot.jpamain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.boot.jpamain.dto.CourseDTO;
import com.boot.jpamain.entity.Course;
import com.boot.jpamain.entity.Student;
import com.boot.jpamain.exceptions.InvalidCourseIdException;
import com.boot.jpamain.exceptions.StudentNotFoundException;
import com.boot.jpamain.mapper.Mapper;
import com.boot.jpamain.repository.CourseRepository;
import com.boot.jpamain.repository.StudentRepository;

@Service
public class CourseService {

	private final CourseRepository courseRepository;
	private final StudentRepository studentRepository;
	private final Mapper mapper;

	public CourseService(CourseRepository courseRepository, StudentRepository studentRepository, Mapper mapper) {
		this.courseRepository = courseRepository;
		this.studentRepository = studentRepository;
		this.mapper = mapper;
	}

	public CourseDTO saveCourse(CourseDTO courseDTO) {

		Course course = mapper.toEntity(courseDTO);

		Student student = studentRepository.findById(courseDTO.getStudentId()).orElseThrow(
				() -> new StudentNotFoundException("Student not found with ID " + courseDTO.getStudentId()));

		course.setStudent(student);

		Course saved = courseRepository.save(course);
		
		System.out.println(saved.getCreatedBy());
		System.out.println(saved.getCreatedDate());

		return mapper.toDto(saved);

	}

	public CourseDTO getCourseById(Integer courseId) {
		
		 if (courseId == null || courseId <= 0) {
		        throw new InvalidCourseIdException("Course ID must be greater than 0");
		    }
		 

		Optional<Course> courseOptional = courseRepository.findById(courseId);

		
		List<Course> byStudentId = courseRepository.findByStudentStudentId(courseOptional.get().getStudent().getStudentId());
		
		System.out.println(byStudentId);
		
		if (courseOptional.isPresent()) {

			return mapper.toDto(courseOptional.get());

		} else
			throw new StudentNotFoundException("Course Not found with id " + courseId);

	}
	
	

}
