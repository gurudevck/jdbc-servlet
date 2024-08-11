package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Collection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.dao.StudentDao;
import com.hsbc.exceptions.DuplicateStudentException;
import com.hsbc.factory.StudentDaoFactory;
import com.hsbc.model.Student;
import com.hsbc.service.*;

/**
 * Servlet implementation class StudentApiServlet
 */
@WebServlet("/StudentApiServlet")
public class StudentApiServlet extends HttpServlet {
	
	private StudentService service = new StudentServiceImpl();
	
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("servlet initialized");
		StudentDao dao = StudentDaoFactory.getInstance().createStudentDao(1);
		if(service instanceof StudentServiceImpl serviceImpl) {
			serviceImpl.setDao(dao);
		}
	}

	public void destroy() {
		System.out.println("servlet destroyed");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//add header to resolve CORS
		response.setHeader("Access-Control-Allow-Origin","*");
		
		response.setContentType("application/json");
		PrintWriter out =  response.getWriter();
				
		Collection<Student> students = service.findAllStudents();
		String data = "[";
		for (int i=0; i<students.size();i ++) {
			Student student = ((List<Student>) students).get(i);
			data += "{\"studentId\": "+student.getStudentId()+", ";
			data+= "\"studentName\": \""+student.getStudentName()+"\",";
			data+= "\"studentScore\": "+student.getStudentScore();
			if(i != students.size()-1)
				data+= "},";
			else
				data+="}";
		}
		data = data + "]";
		out.println(data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//add header to resolve CORS
		response.setHeader("Access-Control-Allow-Origin","*");
		
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		String studentName = request.getParameter("studentName");
		double studentScore = Double.parseDouble(request.getParameter("studentScore"));
		
		Student student = new Student(studentId,studentName,studentScore);
		response.setContentType("application/json");
		PrintWriter out =  response.getWriter();
		try {
			service.addStudent(student);
			//send success response
			out.println("{\"message\":\"Student added successfully\"}");
		} catch (DuplicateStudentException e) {
			//send failure response
			out.println("{\"message\":\"Student already present\"}");
		}
	}

}
