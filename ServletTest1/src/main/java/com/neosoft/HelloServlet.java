package com.neosoft;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("Hello Servlet!");
		
		
		out.println("<table border=2>");
		ServletContext sct = getServletContext();
		Enumeration<String> en2 = sct.getInitParameterNames();
		while(en2.hasMoreElements()) {
			String para = en2.nextElement();
			out.println("<tr> <td> "+para+"</td> <td>"+sct.getInitParameter(para)+"</td>");
		}
		out.println("</table><br><br><hr>");
		
		
		out.close();
	}

}
