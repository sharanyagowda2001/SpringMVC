<%@page import="org.alvas.student_servlet_crud.dto.Student"%>
<%@page import="java.util.List"%>
<%@page import="org.alvas.student_servlet_crud.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<%
 StudentDao dao= new StudentDao();
List<Student> student1 = dao.getAllStudent();
%>
<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Delete</th>
<th>Update</th>
</tr>
<tr>
</tr>
<%for(Student student : student1){%>
<tr>
<td> <%=student.getStuentId()%></td>
<td><%=student.getStudentName()%></td>
<td><%=student.getStudentEmail() %></td>
<td><a href="deletestudent?id=<%= student.getStuentId() %>"><button style="background-color:red">Delete</button></a>
<td><a href="StudentUpdate1?id=<%= student.getStuentId() %>"><button style="background-color:yellow">Update</button></a>
</tr>
<%} %>
</table>
 

</body>
</html>