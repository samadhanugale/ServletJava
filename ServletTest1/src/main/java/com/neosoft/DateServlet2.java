package com.neosoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dateservlet2",loadOnStartup = 1)
public class DateServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet Method : Service gets called.");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h3>Hello"+req.getParameter("txtuser")+" </h3>");
		out.println("<h3>Today's Date is : </h3>");
		out.println("<h2>"+new java.util.Date().toString() +"</h2>");
		out.close();
	}

	

}
