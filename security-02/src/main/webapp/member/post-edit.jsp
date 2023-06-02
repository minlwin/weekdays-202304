<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home | Edit Post</title>
<jsp:include page="/includes/resources.jsp" />
</head>
<body>

<jsp:include page="/includes/public-nav.jsp" >
	<jsp:param value="newpost" name="view"/>
</jsp:include>

<div class="container mt-3">

	<h3>Add New Post</h3>
	
	<form method="post" enctype="multipart/form-data">
		<div class="mb-3">
			<label class="form-label">Post Title</label>
			<input name="title" type="text" class="form-control" placeholder="Enter Post Title" required="required" />
		</div>
		
		<div class="mb-3">
			<label class="form-label">Image Files</label>
			<input name="photo" type="file" class="form-control" />
		</div>
		
		<button class="btn btn-outline-danger" type="submit">Upload</button>
	</form>
	
</div>
</body>
</html>