package com.boot.jpamain.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CourseDTO {

	@NotBlank(message = "courseName name cannot be blank")
	private String courseName;

	@NotNull(message = "Validity date is required")
	@FutureOrPresent(message = "Validity date must be today or in the future")
	private LocalDate validity;

	@NotNull(message = "Student ID is required")
	@Positive(message = "Student ID must be a positive number")
	
	private Integer studentId;
	
	 private String createdBy;
	 
	 private LocalDateTime createdDate;

	// ✅ Don't include student reference here (prevents recursion)

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

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
