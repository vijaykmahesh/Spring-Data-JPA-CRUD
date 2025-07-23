package com.boot.jpamain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.jpamain.dto.CourseDTO;
import com.boot.jpamain.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

	private final CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}

	@PostMapping
	public ResponseEntity<CourseDTO> saveCourse(@Valid @RequestBody CourseDTO courseDTO) {

		CourseDTO course = courseService.saveCourse(courseDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(course);

	}

	
	@GetMapping(value = "/{courseId}",produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<CourseDTO> getCourseById(@PathVariable Integer courseId) {

		CourseDTO course = courseService.getCourseById(courseId);

		return ResponseEntity.ok(course);

	}

}
