<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>   
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home | Details</title>
<jsp:include page="/includes/resources.jsp" />
</head>
<body>

<jsp:include page="/includes/public-nav.jsp" >
	<jsp:param value="memberHome" name="view"/>
</jsp:include>

<div class="container mt-3">
	
	<!-- Post Information -->
	<h3>${dto.title}</h3>
	<div>${dto.postAt}</div>
		
	<!-- Images -->
	<div class="row row-cols-3">
		<c:forEach items="${dto.photos()}" var="photo">
			<app:app-photo photo="${photo}"></app:app-photo>
		</c:forEach>
	</div>
	
	<!-- Comments -->
	<section class="mt-4">
		<h4>Comments</h4>
		
		<!-- New Comment Form -->
		<c:url value="/member/post-comment" var="commentAction"></c:url>
		<form action="${commentAction}" method="post">
			<input type="hidden" name="id" value="${dto.id}" />
			<div class="mb-3">
				<label class="form-label">New Comment</label>
				<textarea rows="4" cols="40" class="form-control" name="details"></textarea>
			</div>
			
			<button type="submit" class="btn btn-outline-danger">Add Comment</button>
		</form>
		
		<!-- Comment List -->
		<div class="list-group list-group-flush">
			<c:forEach items="${dto.comments()}" var="comment">
				<app:app-comment comment="${comment}"></app:app-comment>
			</c:forEach>
		</div>
	</section>
	
</div>

</body>
</html>