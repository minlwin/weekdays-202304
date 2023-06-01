<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home | ${loginUser.name()}</title>
<jsp:include page="/includes/resources.jsp" />
</head>
<body>

<jsp:include page="/includes/public-nav.jsp" >
	<jsp:param value="adminHome" name="view"/>
</jsp:include>


<div class="container mt-3">
	
	<!-- Title -->
	<h3>Members Management</h3>
	
	<!-- Result Grid -->
	<div class="mt-4">
		<c:choose>
			<c:when test="${not empty list}">
			<div class="row-cols-3">
				<c:forEach items="${list}" var="item">
					<div class="col">
					
					</div>
				</c:forEach>			
			</div>
			</c:when>
			
			<c:otherwise>
				<div class="alert alert-info">There is no data.</div>
			</c:otherwise>
		</c:choose>	
	</div>
	

</div>

</body>
</html>