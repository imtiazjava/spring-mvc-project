package com.cgi.dao;

import org.springframework.jdbc.core.JdbcTemplate;
 

import com.cgi.model.Student;

public class StudentDAOImpl implements StudentDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("insidet setjdbc");
		this.jdbcTemplate = jdbcTemplate;
		System.out.println(this.jdbcTemplate);
 
	}

	@Override
	public boolean addStudent(Student student) {
		String query="insert into student values(?,?,?)";
		Object o[]= {student.getSid(),student.getSname(),student.getSmarks()};
		if(this.jdbcTemplate!=null) {
		int i=this.jdbcTemplate.update(query,o);
		System.out.println(i+": record is inserted");
		return true;
		}else {
			System.out.println("inside the else part***8");
			return false;
		}
	}

}
