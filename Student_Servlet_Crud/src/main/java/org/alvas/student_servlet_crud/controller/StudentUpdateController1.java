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

@WebServlet(value = "/StudentUpdate1")
public class StudentUpdateController1 extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			StudentDao dao = new StudentDao();
			
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			Student student = dao.getStudentById(id);
			
			if(student != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("StudentUpdate1.jsp");
				request.setAttribute("student", student);
				dispatcher.forward(request, response);
			}
			else {
				PrintWriter pw = response.getWriter();
				pw.print("Student not found");
			}
		
		
	}

	
}
