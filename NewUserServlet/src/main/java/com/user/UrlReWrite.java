package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 @WebServlet(urlPatterns = "/urlReqrite")
public class UrlReWrite extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("txtuser");
		String pass = req.getParameter("txtpass");
		
		out.print("Welcome "+name);
		
		
		//Url Rewrite
		out.print("<br><a href='viewaccount?name="+name+"&pass="+pass+"'>View Account</a>");
		out.close();
	}

}
