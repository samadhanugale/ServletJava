package com.neosoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Loginservlet")
public class LoginServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		String uname = req.getParameter("txtuser");
		String pass = req.getParameter("txtpass");
		PrintWriter out = resp.getWriter();
		if(uname.toLowerCase().equals("admin") && pass.equals("admin")) {
			req.getRequestDispatcher("dateservlet2	").forward(req, resp);
		}
		else {
			out.println("<h3><font color='red'>Invalid credentials!</font></h3>");
			req.getRequestDispatcher("Login2.html").include(req, resp);
		}
		out.close();
	}
}
