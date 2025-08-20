package com.SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.model.Student;
import com.SpringBoot.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository repo;
	
	public List<Student> getAllStudents(){
		List<Student> students = repo.findAll();
		return students;
	}
	
	public boolean checkData(String email, String password) {
	    // Fetch student by email from the repository
	    Student student = repo.findByEmail(email);

	    // Check if the student exists and the password matches
	    if (student != null && student.getPassword().equals(password)) {
	        return true;
	    } else {
	        return false;
	    }
	}

	
	@Override
	public void insertData(Student student) {

		repo.save(student);
	}

	@Override
	public Student getStudentById(int roll) {
		Student student = repo.findById(roll).get();
		return student;
	}

	@Override
	public void deleteStudentData(int roll) {
		repo.deleteById(roll);
//		boolean tr = repo.existsById(roll);
//		if(tr) {
//			System.out.println("true");
//		}else {
//			System.out.println("False");
//		}
	}

	@Override
	public void updateStuData(Student studata) {
		// TODO Auto-generated method stub
		repo.save(studata);
		//boolean b =repo.existsById(studata);
		
	}


}
