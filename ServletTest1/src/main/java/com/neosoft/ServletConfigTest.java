package com.neosoft;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		name="My Servlet",
		description = "TestServlet discription",
		urlPatterns = "/testconfig",
		initParams = {
				@WebInitParam(name="dbName",value="mydb"),
				@WebInitParam(name="dbType",value="Oracle/mydb")
		},
		loadOnStartup = 1 	
		)
public class ServletConfigTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		ServletConfig sc = getServletConfig();//To get parameters
		
		out.println("<h4>Servlet Name : "+sc.getServletName()+"</h4>");
		Enumeration<String> en = sc.getInitParameterNames();
		
		out.println("<table border=2>");
		while(en.hasMoreElements()) {
			String para = en.nextElement();
			out.println("<tr> <td> "+para+"</td> <td>"+sc.getInitParameter(para)+"</td>");
		}
		out.println("</table><br><br><hr>");
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
