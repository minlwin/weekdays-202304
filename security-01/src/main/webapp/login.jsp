<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<c:url value="/resources/application.css" var="appCss"></c:url>
<link rel="stylesheet" href="${appCss}" />
</head>
<body>

	<h1>Login Page</h1>
	
	<c:url value="/j_security_check" var="loginAction"></c:url>
	<form action="${loginAction}" method="post">
		
		<div class="form-group">
			<label>Login Id</label>
			<input type="text" name="j_username" placeholder="Enter Login Id" />
		</div>
		
		<div class="form-group">
			<label>Password</label>
			<input type="text" name="j_password" placeholder="Enter Password" />
		</div>
		
		<div class="form-group">
			<button type="submit">Login</button>
		</div>
	</form>
	
</body>
</html>