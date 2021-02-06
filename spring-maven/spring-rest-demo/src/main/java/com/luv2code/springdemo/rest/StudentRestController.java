package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;
	// define @PostConstruct to load the student data... only once

	@PostConstruct
	public void loadData() {

		theStudents = new ArrayList<>();

		theStudents.add(new Student("joshna", "guthi"));
		theStudents.add(new Student("yaswanth", "poli"));
		theStudents.add(new Student("kusi", "poli"));
		theStudents.add(new Student("lukky", "guthi"));
		theStudents.add(new Student("yamuna", "poli"));

	}

	// define endpoint for "/students" -return list of students
	
	@GetMapping("/students")
	public List<Student> getStudents() {

		return theStudents;

	}
	// define the endpoint for"/students/{studentid}" -return student at index

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		// just index into the list...keep it simple for now

		// check the studentid against list size
		if ((studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id Not found - " + studentId);
		}

		return theStudents.get(studentId);
	}

	}
