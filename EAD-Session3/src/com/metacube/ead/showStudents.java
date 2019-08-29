package com.metacube.ead;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class showStudents
 */
@WebServlet("/showStudents")
public class showStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showStudents() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Statement stmt = null;
		ResultSet res = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Pra@ajm123");	
			
			stmt = conn.createStatement();
			String query = "select * from student_detail";
			res = stmt.executeQuery(query);
			
			List<Student> studentList = new ArrayList<Student>();
			while(res.next()) {
				Student student = new Student();
				student.setRollNo(res.getInt("roll_no"));
				student.setfName(res.getString("first_name"));
				student.setlName(res.getString("last_name"));
				student.setFatherName(res.getString("father_name"));
				student.setEmail(res.getString("E_mail"));
				student.setStudentClass(res.getInt("class"));
				student.setAge(res.getInt("Age"));
				studentList.add(student);
			}
			request.setAttribute("StudentList", studentList);
			request.getRequestDispatcher("ShowStudents.jsp").forward(request,response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Pra@ajm123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	

	
	
}
