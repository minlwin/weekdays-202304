package com.jdc.demo;

import java.io.IOException;

import com.jdc.demo.util.BaseServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/home", loadOnStartup = 1)
public class PublicHomeServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Search Posts
		
		forward(req, resp, "/home");
	}

}
