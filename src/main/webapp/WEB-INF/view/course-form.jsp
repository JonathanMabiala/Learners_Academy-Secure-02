

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
		
			<!-- need to associate this data with course id -->
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>Title</label></td>
						<td><form:input path="title"/></td>
					</tr>
					<tr>
						<td><label>Hours</label></td>
						<td><form:input path="hours" /></td>
					</tr>
					
					<tr>
					
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