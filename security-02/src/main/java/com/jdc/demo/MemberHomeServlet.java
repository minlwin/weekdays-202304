package com.jdc.demo;

import java.io.IOException;
import java.util.List;

import com.jdc.demo.model.CommentService;
import com.jdc.demo.model.ImageStorageService;
import com.jdc.demo.model.PostService;
import com.jdc.demo.model.dto.LoginUser;
import com.jdc.demo.util.BaseServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = {
				"/member/home",
				"/member/post-edit",
				"/member/post-details",
				"/member/post-comment"
		})
@MultipartConfig
public class MemberHomeServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	
	private PostService service;
	private CommentService commentService;

	@Override
	public void init() throws ServletException {
		service = new PostService(dataSource);
		commentService = new CommentService(dataSource);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// prepare data
		if(req.getServletPath().equals("/member/home")) {
			var keyword = req.getParameter("keyword");
			var list = service.search(req.getRemoteUser(), keyword);
			req.setAttribute("list", list);
		} else {
			
			var id = req.getParameter("id");
			if(null != id && !id.isBlank()) {
				var post = service.findDetailsById(Integer.parseInt(id));
				req.setAttribute("dto", post);
			}		
		}
		
		forward(req, resp, req.getServletPath());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var loginUser = (LoginUser)req.getSession().getAttribute("loginUser");

		if("/member/post-comment".equals(req.getServletPath())) {
			var id = req.getParameter("id");
			var details = req.getParameter("details");
			
			commentService.create(Integer.parseInt(id), loginUser.id(), details);
			
			redirect(resp, "/member/post-details?id=%s".formatted(id));

		} else {
			var imageStorage = new ImageStorageService();
			var imageFileNames = imageStorage.saveImages(getServletContext().getRealPath("/images"), List.of(req.getPart("photo")));
			
			var title = req.getParameter("title");
			var id = service.create(title, imageFileNames, loginUser.id());
			
			redirect(resp, "/member/post-details?id=%d".formatted(id));
		}
	}
}
