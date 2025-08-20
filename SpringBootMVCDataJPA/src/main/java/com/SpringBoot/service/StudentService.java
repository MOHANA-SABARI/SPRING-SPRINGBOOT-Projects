package com.SpringBoot.service;

import java.util.List;

import com.SpringBoot.model.Student;

public interface StudentService {
	
	 List<Student> getAllStudents();
	
	 void insertData(Student student);

	 Student getStudentById(int roll);

	 void deleteStudentData(int roll);

	 void updateStuData(Student studata);

	 boolean checkData(String email, String password);
}
