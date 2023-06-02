<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
<jsp:include page="/includes/resources.jsp" />
</head>
<body>

<jsp:include page="/includes/public-nav.jsp" >
	<jsp:param value="signin" name="view"/>
</jsp:include>

<div class="container mt-3">
	<h3>Member Sign In</h3>
	
	<c:url value="/signin" var="action"></c:url>
	<form action="${action}" method="post" class="w-50">
	
		<c:if test="${not empty param.error}">
			<div class="alert alert-info">
				Please check your login information.
			</div>		
		</c:if>
		
		<div class="mb-3">
			<label class="form-label">Login Id</label>
			<input name="loginId" type="text" placeholder="Enter Login Id" class="form-control" />
		</div>
		
		<div class="mb-3">
			<label class="form-label">Password</label>
			<input name="password" type="password" placeholder="Enter Password" class="form-control" />
		</div>
		
		<div>
			<button type="submit" class="btn btn-danger">Sign In</button>
		</div>

	</form>
</div>

</body>
</html>