package com.boot.jpamain.entity;

import java.time.LocalDate;

import com.boot.jpamain.dto.Auditable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Course extends Auditable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseId;
	
	private String courseName;
	
	private LocalDate validity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_fk_id")
	private Student student;
	

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String courseName, LocalDate validity, Student student) {
		super();
		this.courseName = courseName;
		this.validity = validity;
		this.student = student;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public LocalDate getValidity() {
		return validity;
	}

	public void setValidity(LocalDate validity) {
		this.validity = validity;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", validity=" + validity + ", student="
				+ student + "]";
	}
	
	
	
	

}
