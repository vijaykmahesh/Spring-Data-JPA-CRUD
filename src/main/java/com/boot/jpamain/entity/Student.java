package com.boot.jpamain.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@DynamicInsert
@DynamicUpdate
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;

	private String name;

	private String email;

	private String panNumber;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<Course> courseList = new ArrayList<Course>();

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private Set<Address> addressSet = new HashSet<Address>();

	@OneToOne(cascade = CascadeType.ALL)
	private Passport passport;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String email, List<Course> courseList, Set<Address> addressSet, Passport passport) {
		super();
		this.name = name;
		this.email = email;
		this.courseList = courseList;
		this.addressSet = addressSet;
		this.passport = passport;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

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

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public Set<Address> getAddressSet() {
		return addressSet;
	}

	public void setAddressSet(Set<Address> addressSet) {
		this.addressSet = addressSet;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

}
