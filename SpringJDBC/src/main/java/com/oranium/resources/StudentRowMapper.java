package com.oranium.resources;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.oranium.beans.Student;

public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student stu = new Student();
		stu.setRollnum(rs.getInt("rollnum"));
		stu.setAge(rs.getInt("age"));
		stu.setName(rs.getString("name"));
		stu.setVers(rs.getInt("vers"));
		return stu;
	}
	
}
