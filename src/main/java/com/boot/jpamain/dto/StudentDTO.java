package com.boot.jpamain.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.boot.jpamain.customannotation.ValidPAN;

import jakarta.validation.constraints.NotBlank;

public class StudentDTO {

	@NotBlank(message = "Student name cannot be blank")
	private String name;

	@NotBlank(message = "Email is required")
	private String email;

	@ValidPAN
	private String panNumber;

	private PassportDTO passport;

	private List<CourseDTO> courseList = new ArrayList<CourseDTO>();

	private Set<AddressDTO> addressSet = new HashSet<AddressDTO>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CourseDTO> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<CourseDTO> courseList) {
		this.courseList = courseList;
	}

	public Set<AddressDTO> getAddressSet() {
		return addressSet;
	}

	public void setAddressSet(Set<AddressDTO> addressSet) {
		this.addressSet = addressSet;
	}

	public PassportDTO getPassport() {
		return passport;
	}

	public void setPassport(PassportDTO passport) {
		this.passport = passport;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

}
