package com.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.SpringBoot.model.Student;
@Service
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByEmail(String email);
	
}
