package com.jdc.demo;

import java.io.IOException;

import com.jdc.demo.util.BaseServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = {"/signin", "/signup", "/signout"}, 
		loadOnStartup = 1)
public class SecurityServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getServletPath().equals("/signout")) {
			req.logout();
			redirect(resp, "/home");
		} else {
			forward(req, resp, req.getServletPath());
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getServletPath().equals("/siginin")) {
			signIn(req, resp);
		} else {
			signUp(req, resp);
		}	
	}

	private void signIn(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void signUp(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}
}
