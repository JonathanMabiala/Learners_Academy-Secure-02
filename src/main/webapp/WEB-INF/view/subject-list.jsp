<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subject</title>
</head>
<body>

<div id="wrapper">
		<div id="header">
			<h2>Subject Page</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			<!-- put new button: Add Subjects -->
			
			<input type="button" value="Add  Subject" 
			Onclick = "window.location.href='show_add_form'; return false" class="add-button"/>
			
			<!-- Add out html table here -->
			<table>  
				<tr>
					<th>Title</th>
				
					<!-- loop over and print our courses -->
					
					<c:forEach var="subjects" items="${subjects}">
					
						<!-- construct an "update" link with customer id -->
						<c:url var="updateLink" value="/subject/update">
							<c:param name = "subjectsId" value="${subjects.id}"/>
						</c:url>
						
						<!-- construct a "Delete" link with customer id -->
						<c:url var="deleteLink" value="/subject/delete">
							<c:param name = "subjectId" value="${subjects.id}"/>
						</c:url>
						<tr>
							<td>${subjects.title}</td>
						
							<td>
								<!-- Display the update link-->
								<a href="${updateLink}">Update</a>
								|
								<!-- Display the Delete link-->
								<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
							
							</td>
						
						</tr>
						
					</c:forEach>
				</tr>
			</table>
			<a href="${pageContext.request.contextPath}/">Back to list</a>
		</div>
	</div>
</body>
</html>