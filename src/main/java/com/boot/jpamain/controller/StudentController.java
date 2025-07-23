package com.boot.jpamain.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.jpamain.dto.StudentDTO;
import com.boot.jpamain.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentDTO> saveStudent(@Valid @RequestBody StudentDTO studentDTO) {

		StudentDTO savedStudent = studentService.createStudent(studentDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);

	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable Integer studentId) {

		StudentDTO savedStudent = studentService.getStudentById(studentId);
		
		 return ResponseEntity.ok(savedStudent);

	}
	
//	@GetMapping("/findStudentByCourseName")
//	public ResponseEntity<StudentDTO> findStudentByCourseName(@RequestParam("courseName") String courseName) {
//
//		StudentDTO savedStudent = studentService.findStudentByCourseName(courseName);
//		
//		 return ResponseEntity.ok(savedStudent);
//
//	}

}
