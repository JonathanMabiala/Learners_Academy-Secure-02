<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<h1>
welcome to Learners Academy
</h1>
<br>
<br>
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
</form:form>
<br>
<br>

<a href="course/show_courses">Show Classes</a> 

<br>
<br>

<a href="subject/show_subjects">Show subjects</a>

<br>
<br>

<a href="student/show_students">Show students</a>
<br>
<br>
<a href="teacher/show_teachers">Show teachers</a>
<br>
<br>
<a href="registration/student_registration">Assign Students to Classes</a>
<br>
<br>
<a href="subject/add_subject_to_course">Assign Subjects to Classes</a>
<br>
<br>

</body>
</html>