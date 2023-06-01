package com.jdc.demo;

import java.io.IOException;

import com.jdc.demo.model.MemberService;
import com.jdc.demo.util.BaseServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/admin/home")
public class AdminHomeServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	private MemberService service;

	@Override
	public void init() throws ServletException {
		service = new MemberService(dataSource);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list", service.findAll());
		forward(req, resp, req.getServletPath());
	}

}
