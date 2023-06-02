<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="photo" type="com.jdc.demo.model.dto.PostPhotoDto" required="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="card">
	<c:url value="/images/${photo.path()}" var="imageSrc"></c:url>
	<img src="${imageSrc}" alt="Image" class="card-image-top" />
</div>
