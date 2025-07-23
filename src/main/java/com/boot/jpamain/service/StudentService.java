package com.boot.jpamain.service;

import java.util.Optional;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.boot.jpamain.dto.StudentDTO;
import com.boot.jpamain.entity.Address;
import com.boot.jpamain.entity.Course;
import com.boot.jpamain.entity.Student;
import com.boot.jpamain.events.RegistrationCompleteEvent;
import com.boot.jpamain.exceptions.StudentNotFoundException;
import com.boot.jpamain.mapper.Mapper;
import com.boot.jpamain.repository.StudentRepository;

@Service
public class StudentService {

	private final ApplicationEventPublisher publisher;

	private final StudentRepository studentRepository;

	private final Mapper studentMapper;

	public StudentService(ApplicationEventPublisher publisher, StudentRepository studentRepository,
			Mapper studentMapper) {
		super();
		this.publisher = publisher;
		this.studentRepository = studentRepository;
		this.studentMapper = studentMapper;
	}

	public StudentDTO createStudent(StudentDTO studentDto) {

		// dynamic insert
		// studentDto.setEmail(null);

		Student student = studentMapper.toEntity(studentDto);

		// Set the student in each course
		for (Course course : student.getCourseList()) {
			course.setStudent(student); // 🔥 This is critical
		}

		// Set the student in each Address
		for (Address address : student.getAddressSet()) {
			address.setStudent(student); // 🔥 This is critical
		}

		Student storedStudent = studentRepository.save(student);

		// Publishes a Spring event
		// Internally, Spring uses an Event Multicaster.
		// All @EventListener methods registered for that event type will be called
		// asynchronously or synchronously (depending on setup).
		publisher.publishEvent(new RegistrationCompleteEvent(storedStudent));

		return studentMapper.toDto(storedStudent); // Return DTO from service
	}

	public StudentDTO getStudentById(Integer studentId) {

		Optional<Student> studentOptional = studentRepository.findById(studentId);

		if (studentOptional.isPresent()) {

			return studentMapper.toDto(studentOptional.get());

		} else
			throw new StudentNotFoundException("student Not found with id " + studentId);

	}

//	public StudentDTO findStudentByCourseName(String courseName) {
//		Student student = jpaStreamer.stream(Course.class).filter(course -> course.getCourseName().equals(courseName))
//				.map(Course::getStudent).findFirst().get();
//
//		return studentMapper.toDto(student);
//	}

}
