package com.SpringBoot.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.SpringBoot.model.Student;
import com.SpringBoot.service.StudentService;

@RestController
@RequiredArgsConstructor
public class StudentController {

	@Autowired
	private final StudentService service;

	// Render login page (Thymeleaf template)
	@GetMapping("/login")
	public String login() {
		return "login"; // Returns login.html from the templates folder
	}

	// Handle login validation
	@PostMapping("/login")
	public String validateLogin(@RequestParam String email, @RequestParam String password) {
		boolean isValid = service.checkData(email, password);  // Validate credentials
		if (isValid) {
			return "Login Successful";  // Successful login response
		} else {
			return "Login Failed";  // Failed login response
		}
	}

	// Fetch list of students
	@GetMapping("/login/students")
	public List<Student> listStudents() {
		return service.getAllStudents();  // Returns list of students as JSON
	}

	// Show form for adding a student (if you're using Thymeleaf)
	@GetMapping("/login/students/addform")
	public String createStudentForm() {
		return "student_form"; // Form template for adding a student
	}

	// Add a new student
	@PostMapping("/login/students/addform")
	public String insertStudentData(@RequestBody Student student) {
		service.insertData(student);
		return "Student Added Successfully";
	}

	// Update an existing student by ID
	@PutMapping("/login/students/edit/{roll}")
	public String updateStudentData(@PathVariable int roll, @RequestBody Student student) {
		Student existingStudent = service.getStudentById(roll);
		if (existingStudent != null) {
			existingStudent.setName(student.getName());
			existingStudent.setAge(student.getAge());
			existingStudent.setEmail(student.getEmail());
			existingStudent.setPassword(student.getPassword());
			service.updateStuData(existingStudent);
			return "Student Updated Successfully";
		} else {
			return "Student Not Found";
		}
	}

	// Delete a student by ID
	@DeleteMapping("/login/students/delete/{roll}")
	public String deleteStudent(@PathVariable int roll) {
		service.deleteStudentData(roll);
		return "Student Deleted Successfully";
	}
}
