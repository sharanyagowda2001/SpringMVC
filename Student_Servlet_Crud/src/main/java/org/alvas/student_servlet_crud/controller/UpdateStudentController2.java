package org.alvas.student_servlet_crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alvas.student_servlet_crud.dao.StudentDao;
import org.alvas.student_servlet_crud.dto.Student;
@WebServlet("/StudentUpdate2")
public class UpdateStudentController2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Student student = new Student();
		student.setStuentId(Integer.parseInt(request.getParameter("id")));
		student.setStudentEmail(request.getParameter("email"));
		student.setStudentName(request.getParameter("name"));
		
		StudentDao dao = new StudentDao();
		dao.updateStudentById(student, student.getStuentId());
		
		if(student != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
			dispatcher.include(request, response);
		}
		else {
			PrintWriter pw = response.getWriter();
			pw.print("Student not found");
			
		}
		
	}

}
