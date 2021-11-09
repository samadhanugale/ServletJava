package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/CookieTest")
public class CookieTest extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String uname = req.getParameter("txtuser");
		String pass = req.getParameter("txtpass");
		
		pw.print("Hi "+ uname + " <br><hr>");
		
		//Ceating cookie
		Cookie cookie1 = new Cookie("uname", uname);
		Cookie cookie2 = new Cookie("upass", pass);
		
		//Adding these cookies to response header
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		
		pw.print("<a href='ViewProfile'>View Profile</a>");
		
		//Remove cookie - non persistent way
		Cookie cookie3 = new Cookie("uname","");
		cookie1.setMaxAge(0);
		resp.addCookie(cookie3);
		pw.close();
		pw.close();
	}

}
