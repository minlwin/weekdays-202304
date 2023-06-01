package com.jdc.demo;

import java.io.IOException;

import com.jdc.demo.model.PostService;
import com.jdc.demo.util.BaseServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/home", loadOnStartup = 1)
public class PublicHomeServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	
	private PostService service;
	
	@Override
	public void init() throws ServletException {
		service = new PostService(dataSource);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Search Posts
		var keyword = req.getParameter("keyword");
		var myPost = service.search(null, keyword);
		req.setAttribute("myPost", myPost);
		
		forward(req, resp, "/home");
	}

}
