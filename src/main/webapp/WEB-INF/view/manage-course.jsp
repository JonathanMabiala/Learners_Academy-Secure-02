<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>

<html>


<head>

<meta charset="UTF-8">
<title>Insert title here</title>


</head>

<body>

<form:form action ="assign_teacher" modelAttribute="theForm">

<h1>Assign teachers to ${theForm.courseTitle} subjects</h1>

<br><br> 
<table>
<tr>
	<td>
		Teacher name:
	</td>
	<td>
		<form:select path="teacher">

		<form:options items = "${theForm.teacherOptions}"/>
		
		</form:select>
	</td>
</tr>

<tr>
<td></td>
</tr>
<tr>
	<td>
		Subject name:
	</td>

	<td>
		<form:select path="subject">
		
		<form:options items = "${theForm.courseSubjectOptions}"/>
		
		</form:select>
	</td>
</tr>

<tr>
	<td></td>
	<td><input type="submit" value="Assign" /></td>
</tr>
</table>
<p>
	<a href="${pageContext.request.contextPath}/">Back to list</a>
</p>

</form:form>

</body>
</html>
