<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<div class="navbar navbar-expand bg-danger navbar-dark">
	<div class="container">
		<c:url value="/home" var="home"></c:url>
		<a href="${home}" class="navbar-brand">INSTA-GRAM</a>
		
		<c:choose>
			
			<c:when test="${empty loginUser}">
				<ul class="navbar-nav">
				
					<li class="nav-item">
						<c:url value="/signup" var="signUp"></c:url>
						<a href="${signUp}" class="nav-link ${param.view eq 'signup' ? 'active' : ''}">Sign Up</a>
					</li>
					<li class="nav-item">
						<c:url value="/signin" var="signIn"></c:url>
						<a href="${signIn}" class="nav-link ${param.view eq 'signin' ? 'active' : ''}">Sign In</a>
					</li>
				</ul>
			</c:when>
			
			<c:otherwise>

				<ul class="navbar-nav">
					
					<c:if test="${loginUser.hasRole('Member')}">
						<li class="nav-item">
							<c:url value="/member/home" var="memberHome"></c:url>
							<a href="${memberHome}" class="nav-link ${param.view eq 'memberHome' ? 'active' : ''}">Home</a>
						</li>
			
						<li class="nav-item">
							<c:url value="/member/post-edit" var="newPost"></c:url>
							<a href="${newPost}" class="nav-link ${param.view eq 'newpost' ? 'active' : ''}">New Post</a>
						</li>
					</c:if>
					
					<c:if test="${loginUser.hasRole('Admin')}">
						<li class="nav-item">
							<c:url value="/admin/home" var="adminHome"></c:url>
							<a href="${adminHome}" class="nav-link ${param.view eq 'adminHome' ? 'active' : ''}">Member Management</a>
						</li>
					</c:if>
					
					<li class="nav-item">
						<c:url value="/signout" var="signOut"></c:url>
						<a href="${signOut}" class="nav-link">Sign Out</a>
					</li>
				</ul>				
							
			</c:otherwise>
			
		</c:choose>
		
	</div>
</div>