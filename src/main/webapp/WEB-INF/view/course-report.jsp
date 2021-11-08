<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, td, th {
  border: 1px solid black;
}

table {
  width: 20%;
  border-collapse: collapse;
}
</style>
<meta charset="UTF-8">
<title>Courses</title>
</head>
<body>

<div id="wrapper">
		<div id="header">
			<h1>${course.title}</h1>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			<table style="border: black">  
					<tr>
						<th>Subject</th>
						
						<th>Teacher</th>
						<!-- loop over and print our courses -->
						
						
					<c:forEach var="theSubjects" items="${theSubjects}">
							
							<tr>
								
								<td>${theSubjects.title} </td>
								<td>${theSubjects.getTeacher().firstName} ${theSubjects.getTeacher().lastName}</td>
								
								
							</tr>
							
					</c:forEach>
					</tr>
				</table> 
			<br><br>
			 	<table>  
				<tr>
					<th>Student</th>
					<th>Email</th>
					<!-- loop over and print our courses -->
					
					<c:forEach var="theStudents" items="${theStudents}">
				
						
						<tr>
					
							<td>${theStudents.firstName} ${theStudents.lastName}</td>
							<td>${theStudents.email}</td>
						
						</tr>
						
					</c:forEach>
			</tr>
			</table> 
			
		
			<p>
			<a href="${pageContext.request.contextPath}/course/show_courses">Back to list</a>
			</p>
		</div>
	</div>
</body>
</html>