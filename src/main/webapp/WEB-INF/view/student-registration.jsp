<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>

<html>


<head>

<meta charset="UTF-8">
<title>Insert title here</title>


</head>

<body>

<form:form action ="save" modelAttribute="theStudentForm">

<h1>Student Registration</h1>

<br><br>

Student Names:

<form:select path="studentName">

<form:options items = "${theStudentForm.studentOptions}"/>

</form:select>


<br><br>

Course Names:

<form:select path="courseTitle">

<form:options items = "${theStudentForm.courseOptions}"/>

</form:select>
<input type="submit" value="submit" />

</form:form>

<br>
<br>
<a href="${pageContext.request.contextPath}/">Back to list</a>

</body>
</html>
