package com.oranium.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JavaFileConfig {
	
	@Bean
	public DriverManagerDataSource myDataSource() {
		
		
		DriverManagerDataSource dn = new DriverManagerDataSource();
		
		dn.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dn.setUrl("jdbc:mysql://localhost:3306/java");
		dn.setUsername("root");
		dn.setPassword("Moha12Villan13");
		
		return dn;
		
	}
	
	@Bean
	public JdbcTemplate myJdbcTemplate() {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(myDataSource());
		
		return jt;
	}
}
