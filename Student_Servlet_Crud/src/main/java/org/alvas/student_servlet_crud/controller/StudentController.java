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

@WebServlet("/student")
public class StudentController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentName = request.getParameter("studentName");
		String studentEmail = request.getParameter("studentEmail");
		
		Student stu = new Student();
		
		stu.setStudentName(studentName);
		stu.setStudentEmail(studentEmail);
		
		StudentDao dao = new StudentDao();
		
		dao.saveStudent(stu);
		
		PrintWriter pw = response.getWriter();
		
		pw.write("<html><body><h1>Data Inserted Succesfully</h1></body></html>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("RegistrationStudent");
	}

}
