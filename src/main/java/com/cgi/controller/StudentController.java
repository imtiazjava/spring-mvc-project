package com.cgi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.cgi.dao.StudentDAOImpl;
import com.cgi.model.Student;

public class StudentController implements Controller {

	 
	private StudentDAOImpl sdao;
	
	public void setSdao(StudentDAOImpl sdao) {
		this.sdao = sdao;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 //capture the information
		String sid=request.getParameter("sid");
		int id=Integer.parseInt(sid);
		String sname=request.getParameter("sname");
		String smarks=request.getParameter("smarks");
		int marks=Integer.parseInt(smarks);
		System.out.println(sid+","+sname+","+smarks);
		
		
		//store the data into the student object
		Student student=new Student();
		student.setSid(id);
		student.setSname(sname);
		student.setSmarks(marks);
		
		 
		
		boolean status=this.sdao.addStudent(student);
		ModelAndView mv=null;
		if(status==true) {
			mv=new ModelAndView("success");
		}else {
			mv=new ModelAndView("error");
		}
		return mv;
	}

}
