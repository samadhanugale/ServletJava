package com.neosoft;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.controller.StudentController;
import com.neosoft.model.Student;

@WebServlet(urlPatterns = "/registeration")
public class RegistrationServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		//JDBC Controller calls
		Student student = new Student();
		
		student.setStdName(req.getParameter("stname"));
		student.setStdCourse(req.getParameter("stcourse"));
		student.setMarks(Integer.parseInt(req.getParameter("stmarks")));
		
		try {
			if(StudentController.insertStudent(student) == 1) {
				out.println("</h2>Registration Done</h2>");
			}
			else {
				out.println("</h2>Registration not Done</h2>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.close();
	}

}
