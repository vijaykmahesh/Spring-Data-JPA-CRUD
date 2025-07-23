package com.boot.jpamain.events;

import com.boot.jpamain.entity.Student;

public class RegistrationCompleteEvent {

	private final Student student;

	public RegistrationCompleteEvent(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}
}
