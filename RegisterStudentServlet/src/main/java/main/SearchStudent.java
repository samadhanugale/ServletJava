package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.JDBCProperties;
import model.Student;

@WebServlet(urlPatterns = "/searchStudent")
public class SearchStudent extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		int id=Integer.parseInt(req.getParameter("search"));
		List<Student> students=new ArrayList<Student>();
		Connection con=JDBCProperties.getConnection();
		
		
		try {
			String searchQuery="SELECT * FROM MYDB.STUDENT WHERE stdid=?";
			
			
			PreparedStatement pst=con.prepareStatement(searchQuery);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			out.println("<table border=2>");
			while(rs.next()) {
				Student student = new Student(rs.getString(2),rs.getString(3), rs.getInt(4));
				students.add(student);
				System.out.println("Id : "+rs.getString(1)+"Name : "+rs.getString(2)+"Course : "+rs.getString(3)+"Marks : "+rs.getString(4));
				out.println("<tr> <td>Id: </td><td>"+rs.getString(1)+"</td></tr><tr> <td>Name : </td><td>"+rs.getString(2)+"</td><tr><tr><td>Course : </td><td>"+rs.getString(3)+"</td></tr> <tr><td>Marks : </td><td>"+rs.getString(4)+"</td>");
			}
			out.println("</table><br><br><hr>");
			out.println("<h3><font color='green'>Search Another</font></h3>");
			req.getRequestDispatcher("Search.html").include(req, resp);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
