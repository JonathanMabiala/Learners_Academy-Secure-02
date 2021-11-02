<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher Form</title>
<link 	type="text/css" 
		rel="stylesheet" 
		href="${pageContext.request.contextPath}/assets/css/style.css" />
<link 	type="text/css" 
		rel="stylesheet" 
		href="${pageContext.request.contextPath}/assets/css/add-customer-style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Register Teachers</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Teacher</h3>
		
		<form:form action="save_teacher" modelAttribute="tempTeacher" method="POST">
		
			<!-- need to associate this data with teacher id -->
			
			<form:hidden path="id"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>First Name</label></td>
						<td><form:input path="firstName"/></td>
					</tr>
					<tr>
						<td><label>Last Name</label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><label>Email</label></td>
						<td><form:input path="email" /></td>
					</tr>
					
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>
			
			
			
		</form:form>
		<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/teacher/show_teachers">Back to list</a>
		</p>
	</div>

</body>
</html>