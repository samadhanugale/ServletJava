package com.neosoft.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neosoft.model.Student;

public class StudentController {
	public static List<Student> getAllStudent() throws Exception {
		List<Student> students = new ArrayList<Student>();
		Connection con = JDBCProperties.getConnection();
		try {
			String querry = "SELECT * FROM mydb.student";
			PreparedStatement pst = con.prepareStatement(querry);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Student student = new Student(rs.getString(2), rs.getString(3), rs.getInt(4));
				students.add(student);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return students;
	}
	
	//For new student insertion
	public static int insertStudent(Student student) throws SQLException{
		int flag=0;
		Connection con = JDBCProperties.getConnection();
		
		try {
			String insertQuerry = "INSERT INTO mydb.student(stdname,stdcourse,marks) VALUES(?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(insertQuerry);
			pst.setString(1, student.getStdName());
			pst.setString(2, student.getStdCourse());
			pst.setInt(3, student.getMarks());	
			flag = pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(con!=null) {
			con.close();
			}
		}
		return flag;
		
	}
}
