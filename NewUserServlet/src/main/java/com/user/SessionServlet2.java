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


@WebServlet(urlPatterns = "/myInfo")
public class SessionServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		String name =(String) session.getAttribute("name");
		String pass =(String) session.getAttribute("pass");
		
		
		out.print("Hi "+name+"<br>");
		out.print("Your pass is : "+pass+"<br>");
		
		String createTime = new Date(session.getCreationTime()).toString();
		out.print("Session Created on : "+createTime+"<br>");
		out.print("Session ID : "+session.getId()+"<br>");
		//Setting max interval to activate session. after that, session will be terminated
		session.setMaxInactiveInterval(15);
		out.print("Session Interval time :"+session.getMaxInactiveInterval()+"<br>");
		out.close();
	}

}
