<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<div class="navbar navbar-expand bg-danger navbar-dark">
	<div class="container">
		<span class="navbar-brand">INSTA-GRAM</span>
		
		<ul class="navbar-nav">
		
			<li class="nav-item">
				<c:url value="/home" var="home"></c:url>
				<a href="${home}" class="nav-link ${param.view eq 'home' ? 'active' : ''}">Home</a>
			</li>

			<li class="nav-item">
				<c:url value="/signup" var="signUp"></c:url>
				<a href="${signUp}" class="nav-link ${param.view eq 'signup' ? 'active' : ''}">Sign Up</a>
			</li>
			<li class="nav-item">
				<c:url value="/signin" var="signIn"></c:url>
				<a href="${signIn}" class="nav-link ${param.view eq 'signin' ? 'active' : ''}">Sign In</a>
			</li>
		</ul>
	</div>
</div>