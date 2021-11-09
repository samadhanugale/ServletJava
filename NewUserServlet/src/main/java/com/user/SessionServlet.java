package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns = "/sessionCheck")
public class SessionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("txtuser");
		String pass = req.getParameter("txtpass");
		
		out.print("Welcome "+name);
		
		HttpSession session = req.getSession();
		session.setAttribute("name",name);
		session.setAttribute("pass",pass);
		
		out.print("Hi "+name+"<br>");
		out.print("Your pass is : "+pass);
		
		out.print("<a href='myInfo'>View Info</a>");
		out.close();
		
	}

}
