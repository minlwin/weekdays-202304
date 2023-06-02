package com.jdc.demo;

import java.io.IOException;
import java.util.ArrayList;

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
				"/member/post-details"
		})
@MultipartConfig
public class MemberHomeServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	
	private PostService service;

	@Override
	public void init() throws ServletException {
		service = new PostService(dataSource);
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
		
		var imageStorage = new ImageStorageService();
		
		var imageFileNames = imageStorage.saveImages(getServletContext().getRealPath("/images"), new ArrayList<>(req.getParts()));
		
		var title = req.getParameter("title");
		var loginUser = (LoginUser)req.getSession().getAttribute("loginUser");
		var id = service.create(title, imageFileNames, loginUser.id());
		
		redirect(resp, "/member/post-details?id=%d".formatted(id));
	}
}
