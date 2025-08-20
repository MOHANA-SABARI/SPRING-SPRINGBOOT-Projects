package com.oranium.SpringJDBC;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.oranium.beans.Student;
import com.oranium.resources.*;

public class App {
  public static void main(String[] args) {
   // System.out.println("Hello World!");
	  
	  
	  int rollnum =1;
	  int age=21;
	  String name = "Moha";
	  int vers = 10;
	  ApplicationContext con= new AnnotationConfigApplicationContext(JavaFileConfig.class);
	  JdbcTemplate jd = (JdbcTemplate)con.getBean("myJdbcTemplate");
	  
//	  String inquery = "insert into spring values (?,?,?,?)";
//	  
//	  int count = jd.update(inquery,rollnum,age,name,vers);
//	  
//	  if(count>0) {
//		  System.out.println("Insertion Succesful.......");
//	  }else {
//		  System.out.println("Failed........");
//	  }
	  
	  String checkq = "select * from spring";
	  
	  List<Student> qu = jd.query(checkq,new StudentRowMapper());
	  
	  for(Student s : qu) {
		  System.out.println("Rollnum          age             Name            version");
		  System.out.println(s.getRollnum() +"               "+ s.getAge()+"               "+s.getName()+"               "+s.getVers() );
		  System.out.println("----------------------------------------------------------------------");
	  }
  }
}
