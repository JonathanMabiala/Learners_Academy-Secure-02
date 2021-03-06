<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<style>
	.failed {
		color: red;
	}
</style>
</head>
<body>
<h3>Learner's Academy</h3>

	<form:form action="${pageContext.request.contextPath}/authenticate_the_user"
		  method="POST">
		  <!-- Check for login error -->
		  <c:if test="${param.error !=null }">
		  	<i class="failed">Sorry! You entered invalid username/password.</i>
		  </c:if>
		  <p>
		  	User name: <input type="text" name="username"/>
		  </p>
		  
		  <p>
		  	password : <input type="password" name="password"/>
		  </p>
		  
		  <input type="submit" value = "Login"/>
		  
  	</form:form>
</body>
</html>