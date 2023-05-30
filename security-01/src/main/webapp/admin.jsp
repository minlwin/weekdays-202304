<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
<c:url value="/resources/application.css" var="appCss"></c:url>
<link rel="stylesheet" href="${appCss}" />
</head>
<body>

	<h1>Admin Home</h1>
	
	<section>
		<c:url value="/home" var="memberLink"></c:url>
		<a href="${memberLink}" class="btn-link">Go Home</a>

		<c:url value="/logout" var="logoutLink"></c:url>
		<a href="${logoutLink}" class="btn-link">Logout</a>
	</section>
	
</body>
</html>