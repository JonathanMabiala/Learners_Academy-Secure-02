<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>

<html>


<head>

<meta charset="UTF-8">
<title>Insert title here</title>


</head>

<body>

<form:form action ="save_subject_to_course" modelAttribute="theForm">

<h1>Add Subject to Class</h1>

<br><br>
<table>
<tr>
	<td>
		Subject names:
	</td>
	<td>
		<form:select path="subjectId">

		<form:options items = "${theForm.subjectOptions}"/>
		
		</form:select>
	</td>
</tr>

<tr>
<td></td>
</tr>
<tr>
	<td>
		Course names:
	</td>

	<td>
		<form:select path="courseId">
		
		<form:options items = "${theForm.courseOptions}"/>
		
		</form:select>
	</td>
</tr>

<tr>
	<td></td>
	<td><input type="submit" value="submit" /></td>
</tr>
</table>


</form:form>

</body>
</html>
