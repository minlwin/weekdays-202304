package com.jdc.demo;

import java.io.IOException;

import com.jdc.demo.model.LoginUserService;
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
	
	private LoginUserService service;
	
	@Override
	public void init() throws ServletException {
		service = new LoginUserService(dataSource);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getServletPath().equals("/signout")) {
			req.getSession().invalidate();
			redirect(resp, "/home");
		} else {
			forward(req, resp, req.getServletPath());
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getServletPath().equals("/signin")) {
			signIn(req, resp);
		} else {
			signUp(req, resp);
		}	
	}

	private void signIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var loginId = req.getParameter("loginId");
		var password = req.getParameter("password");
		
		req.login(loginId, password);
		
		var loginUser = service.findUserByLoginId(loginId);
		
		req.getSession(true).setAttribute("loginUser", loginUser);
		
		redirect(resp, loginUser.role().equals("Member") ? "/member/home" : "/admin/home");
		
	}

	private void signUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var name = req.getParameter("name");
		var loginId = req.getParameter("loginId");
		var password = req.getParameter("password");
		
		service.createMember(name, loginId, password);
		
		signIn(req, resp);
	}
}
