<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<c:url value="/resources/application.css" var="appCss"></c:url>
<link rel="stylesheet" href="${appCss}" />
</head>
<body>

	<h1>Servlet Security</h1>
	
	<section>
	
		<c:url value="/admin" var="adminLink"></c:url>
		<a href="${adminLink}" class="btn-link">Admin Home</a>
		
		<c:url value="/member" var="memberLink"></c:url>
		<a href="${memberLink}" class="btn-link">Member Home</a>
	
	</section>
	
</body>
</html>