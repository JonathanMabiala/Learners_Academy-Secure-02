<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher</title>
</head>
<body>

<div id="wrapper">
		<div id="header">
			<h1>Teacher Page</h1>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			<!-- put new button: Add Courses -->
			
			<input type="button" value="Add  Teacher" 
			Onclick = "window.location.href='show_add_form'; return false" class="add-button"/>
			
			<!-- Add out html table here -->
			<table>  
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<!-- loop over and print our courses -->
					
					<c:forEach var="teachers" items="${teachers}">
					
						<!-- construct an "update" link with customer id -->
						<c:url var="updateLink" value="/teacher/update">
							<c:param name = "teacherId" value="${teachers.id}"/>
						</c:url>
						
						<!-- construct a "Delete" link with customer id -->
						<c:url var="deleteLink" value="/teacher/delete">
							<c:param name = "teacherId" value="${teachers.id}"/>
						</c:url>
						<tr>
							<td>${teachers.firstName}</td>
							<td>${teachers.lastName}</td>
							<td>${teachers.email}</td>
							<td>
								<!-- Display the update link-->
								<a href="${updateLink}">Update</a>
								|
								<!-- Display the Delete link-->
								<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this teacher?'))) return false">Delete</a>
							
							</td>
						
						</tr>
						
					</c:forEach>
				</tr>
			</table>
			<p>
			<a href="${pageContext.request.contextPath}/">Back to list</a>
			</p>
		</div>
	</div>
</body>
</html>