package com.jdc.demo;

import java.io.IOException;

import com.jdc.demo.model.PostService;
import com.jdc.demo.util.BaseServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = {
				"/member/home",
				"/member/post-edit",
				"/member/post-details"
		})
public class MemberHomeServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	
	private PostService service;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// prepare data
		if(req.getServletPath().equals("/member/home")) {
			var keyword = req.getParameter("keyword");
			var myPost = service.search(keyword);
			req.setAttribute("myPost", myPost);
		} else {
			
			var id = req.getParameter("id");
			if(null != id && !id.isBlank()) {
				var post = service.findDetailsById(Integer.parseInt(id));
			}		
		}
	}
}
