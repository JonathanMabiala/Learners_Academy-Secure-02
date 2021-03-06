<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courses</title>
</head>
<body>

<div id="wrapper">
		<div id="header">
			<h2>Courses Pages</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			<!-- put new button: Add Courses -->
			
			<input type="button" value="Add Courses" 
			Onclick = "window.location.href='show_add_form'; return false" class="add-button"/>
			
			<!-- Add out html table here -->
			<table>  
				<tr>
					<th>Title</th>
					<th>Hours</th>
					<!-- loop over and print our courses -->
					
					<c:forEach var="courses" items="${courses}">
					
						<!-- construct an "update" link with customer id -->
						<c:url var="updateLink" value="/course/show_form_for_update">
							<c:param name = "courseId" value="${courses.id}"/>
						</c:url>
						
						<!-- construct a "Delete" link with course id -->
						<c:url var="deleteLink" value="/course/delete">
							<c:param name = "courseId" value="${courses.id}"/>
						</c:url>
						<!-- construct a "Manage" link with course id -->
						<c:url var="manageLink" value="/course/manage">
							<c:param name = "courseId" value="${courses.id}"/>
						</c:url>
						<!-- construct a "Report" link with course id -->
						<c:url var="reportLink" value="/course/report">
							<c:param name = "courseId" value="${courses.id}"/>
						</c:url>
						<tr>
							<td>${courses.title}</td>
							<td>${courses.hours}</td>
							<td>
								<!-- Display the update link-->
								<a href="${updateLink}">Update</a>
								|
								<!-- Display the Delete link-->
								<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this course?'))) return false">Delete</a>
								|
									<!-- Display the Manage link-->
								<a href="${manageLink}">Manage</a>
								|
								<!-- Display the Report link-->
								<a href="${reportLink}">Report</a>
							
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