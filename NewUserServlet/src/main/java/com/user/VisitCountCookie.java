package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/VisitCount")
public class VisitCountCookie extends HttpServlet {

	private static final long serialVersionUID = 1L;
	int count = 1;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<h2>Welcome here</h2>");
		
		String visit = String.valueOf(count);
		Cookie cookie = new Cookie("Visit",visit);
		resp.addCookie(cookie);
		
		int oldCount = Integer.parseInt(cookie.getValue());
		
		if(oldCount == 1) {
			out.print("Welcome! This is your first visit! <br>");
		}
		else {
			out.print("You have visited "+count + " Times <br>");
		}
		count++;
		
		out.print(" <br> Max age of cookie : "+cookie.getMaxAge() + "<br>");
		out.print("Cookie Length : "+req.getCookies().length);
		//Make cookie non persistent
		//cookie.setMaxAge(-1);
		
		
		
		out.close();
		
	}
}
