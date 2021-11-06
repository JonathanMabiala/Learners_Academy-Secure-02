

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<h2>Register Courses</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Course</h3>
		
		<form:form action="save_course" modelAttribute="theForm"  method="POST">
		
			<!-- need to associate this data with customer id -->
			<form:hidden path="courseId"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>Title</label></td>
						<td><form:input path="courseTitle"/></td>
					</tr>
					<tr>
						<td><label>Hours</label></td>
						<td><form:input path="courseHours" /></td>
					</tr>
					
					<tr>
					<td></td>
					<td><h3>Teacher Details</h3></td>
					</tr>
					
					<tr>
					
					<td><label>Teacher list</label></td>
					<td><form:input path="teacherFirstName"  /></td>
					
					</tr>
					
					<tr>
					<td><label>Last Name</label></td>
					<td><form:input path="teacherLastName" /></td>
					</tr>
					<tr>
					<td><label>Email</label></td>
					<td><form:input path="teacherEmail" /></td>
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
			<a href="${pageContext.request.contextPath}/course/show_courses">Back to list</a>
		</p>
	</div>

</body>
</html>