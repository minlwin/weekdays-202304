package com.jdc.demo.util;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void redirect(HttpServletResponse resp, String url) throws IOException {
		resp.sendRedirect(getServletContext().getContextPath().concat(url));
	}
	
	protected void forward(HttpServletRequest req, HttpServletResponse resp, String jsp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("%s.jsp".formatted(jsp))
			.forward(req, resp);
	}
}
