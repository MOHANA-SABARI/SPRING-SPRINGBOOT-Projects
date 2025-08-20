package com.SpringBoot.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.SpringBoot.model.Student;
import com.SpringBoot.service.StudentService;

@Controller
@RequiredArgsConstructor
public class StudentController {
	
	@Autowired
	private final StudentService service;

	@GetMapping("/login")
	public String login() {
		return "login"; // This will return login.html from the templates folder
	}
	
	@PostMapping("/login")
	public String validateLogin(@RequestParam String email,@RequestParam String password) {
	    boolean isValid = service.checkData(email, password);  // Validate using the service layer
	    System.out.println(isValid);
	    if (isValid) {
	        return "home";  // Redirect to the students page on successful login
	    } else {
	        return "redirect:/login?error=true";  // Redirect back to login with an error
	    }
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute Student student) {
		
		service.insertData(student);
		return "redirect:/login";
	}
	
	@GetMapping("/login/students")
	public String listStudent(Model model)
	{
		List<Student> students = service.getAllStudents();
		model.addAttribute("modelstudents", students);
		return "students_list" ;
//		try {
//			//Object s;
//			for(Student s : student) {
//				System.out.println(s);
//			}
//		}catch(Exception e) {
//			
//		}
//		return student;
	}
	
	@GetMapping("/login/students/addform")
	public String createStudentForm()
	{
		return "student_form";
	}
	
	@PostMapping("/login/students/addform")
	public String insertStudentData(@ModelAttribute Student student) {
		
		service.insertData(student);
		
		return "redirect:/login/students";
	}
	
	@GetMapping("/login/students/edit/{roll}")
	public String showUpdateForm(@PathVariable int roll, Model model)
	{
		Student student = service.getStudentById(roll);
		model.addAttribute("students", student);		
		return "update_form";
	}
	
	@DeleteMapping("/login/students/delete/{roll}")
	public String getMethodName(@PathVariable int roll)
	{
		service.deleteStudentData(roll);
		return "redirect:/login/students";
	}

	@PostMapping("/login/students/edit/{roll}")
	public String updateStudentData(@PathVariable int roll, @ModelAttribute Student student) {
		
		Student studata = service.getStudentById(roll);
		studata.setAge(student.getAge());
		studata.setName(student.getName());
		studata.setEmail(student.getEmail());
		studata.setPassword(student.getPassword());
		
		service.updateStuData(studata);
		return "redirect:/login/students";
	}

}
