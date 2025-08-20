package com.SpringBoot.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roll;
	private int age;
	private String name;
	private String email;
	private String password;
	
	public Student(int age, String name, String email, String password) {
		super();
		this.age = age;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
		
}
