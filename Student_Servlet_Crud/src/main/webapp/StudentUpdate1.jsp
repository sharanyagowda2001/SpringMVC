<%@page import="org.alvas.student_servlet_crud.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Student stu = (Student)request.getAttribute("student"); %>
<form action="StudentUpdate2">
<input type="text" name="id" value="<%= stu.getStuentId() %>" readonly="readonly">
<input type="text" name="email" value="<%= stu.getStudentEmail() %>" >
<input type="text" name="name" value="<%= stu.getStudentName() %>" >
<input type="submit" value="submit">
</form>
</body>
</html>