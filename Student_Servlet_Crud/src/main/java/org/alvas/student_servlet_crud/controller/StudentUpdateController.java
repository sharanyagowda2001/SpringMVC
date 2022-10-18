package org.alvas.student_servlet_crud.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alvas.student_servlet_crud.dao.StudentDao;
@WebServlet(value = "/student1")
public class StudentUpdateController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDao();
		
		Integer id = Integer.parseInt(request.getParameter("studentId"));
		
		dao.updateStudent(id, request.getParameter("studentName"), request.getParameter("studentEmail"));
		
	}

}
