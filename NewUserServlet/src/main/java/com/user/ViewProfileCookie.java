package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ViewProfile")
public class ViewProfileCookie extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		Cookie cookies[] = req.getCookies();
		
		for (Cookie cookie : cookies) {
			pw.print(cookie.getName()+" : " +cookie.getValue()+"<br>");	
		}
		pw.print("<br><hr>");
		pw.print(cookies[0].getValue()+"<br>");
		pw.print(cookies[1].getValue()+"<br>");
		
		
	}

}

