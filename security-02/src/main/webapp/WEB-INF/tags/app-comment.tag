<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="comment" required="true" type="com.jdc.demo.model.dto.PostCommentDto" %>

<section>
	<h4>${comment.details()}</h4>
	<div class="d-flex justify-content-between">
		<!-- Comment At -->
		<div>${comment.commentAt}</div>
		
		<!-- Comment User -->
		<div>${comment.owner}</div>
	</div>
</section>