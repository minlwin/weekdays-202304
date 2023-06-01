<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<jsp:include page="/includes/resources.jsp" />
</head>
<body>

<jsp:include page="/includes/public-nav.jsp" >
	<jsp:param value="signup" name="view"/>
</jsp:include>

<div class="container mt-3">
	<h3>Sign Up</h3>
	
	<c:url value="/signup" var="action"></c:url>
	<form action="${action}" method="post" class="w-50">
		
		<div class="mb-3">
			<label class="form-label">Name</label>
			<input name="name" type="text" placeholder="Enter Member Name" class="form-control" />
		</div>

		<div class="mb-3">
			<label class="form-label">Login Id</label>
			<input name="loginId" type="text" placeholder="Enter Login Id" class="form-control" />
		</div>
		
		<div class="mb-3">
			<label class="form-label">Password</label>
			<input name="password" type="password" placeholder="Enter Password" class="form-control" />
		</div>
		
		<div>
			<button type="submit" class="btn btn-danger">Sign Up</button>
		</div>

	</form>
</div>

</body>
</html>