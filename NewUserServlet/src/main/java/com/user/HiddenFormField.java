package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/HiddenForm")
public class HiddenFormField extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String uname = req.getParameter("txtuser");
		String pass = req.getParameter("txtpass");
		
		out.print("Welcome "+uname+"<br>");
		//Creating a form with invisible text field
		
		out.print("<form action='HiddenServlet2'> ");
		out.print("<input type='hidden' name='uname' value='"+uname+"'>");
		out.print("<input type='submit' value='Go'>");
		out.print("</form>");
		
		
		
	}

}
