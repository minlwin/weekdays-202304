<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Instergram</title>

<jsp:include page="/includes/resources.jsp" />

</head>
<body>

<jsp:include page="/includes/public-nav.jsp" >
	<jsp:param value="home" name="view"/>
</jsp:include>

</body>
</html>