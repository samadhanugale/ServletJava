package com.neosoft;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/UserDetails")
public class UserServlet extends HttpServlet {
	String msg = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		msg="Init method ";
		System.out.println("Welcome message : "+msg);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
	
		PrintWriter out = resp.getWriter();
		Enumeration<String> en = req.getParameterNames();
		out.println("<table border=2>");
		while(en.hasMoreElements()) {
			String para = (String)en.nextElement();
			out.println("<tr> <td> Parameter</td><td> "+para+"</td> </tr><tr> <td> Value : </td><td>"+req.getParameter(para)+"</td>");
		}
		out.println("</table><br><br><hr>");
		
		//Java8 
		out.println("<table border=2>");
		req.getParameterMap().keySet().forEach(k -> {
			out.println("<tr> <td> Parameter</td><td> "+k+"</td> </tr><tr> <td> Value : </td><td>"+req.getParameter(k)+"</td>");
			
		});
		out.println("</table><br><br><hr>");
		
		
		//Get header info from request
		Enumeration<String> en2 = req.getHeaderNames();
		out.println("<table border=1>");
		while(en2.hasMoreElements()) {
			String headername = (String)en2.nextElement();
			out.println("<tr> <td> Parameter</td><td> "+headername+"</td> </tr><tr> <td> Value : </td><td>"+req.getHeader(headername)+"</td>");
		}
		out.println("</table>");
		
		
		out.close();
	}

}
