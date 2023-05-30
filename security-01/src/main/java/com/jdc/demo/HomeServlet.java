package com.jdc.demo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {
		"/home",
		"/admin",
		"/member"
})
public class HomeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var page = switch (req.getServletPath())  {
		case "/admin" -> "/admin.jsp";
		case "/member" -> "/member.jsp";
		default -> "/home.jsp";
		};
		
		getServletContext().getRequestDispatcher(page).forward(req, resp);
	}
	
}
